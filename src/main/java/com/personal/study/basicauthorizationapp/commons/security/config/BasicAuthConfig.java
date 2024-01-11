package com.personal.study.basicauthorizationapp.commons.security.config;

import com.personal.study.basicauthorizationapp.commons.security.services.MongoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class BasicAuthConfig {

    @Autowired
    private MongoUserDetailsService mongoUserDetailsService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests((authorize) ->
                        authorize.anyRequest().authenticated())
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf((csrf) ->
                        csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/user")))
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    AuthenticationManager authenticationManager() {

        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(mongoUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        var providerManager = new ProviderManager(authenticationProvider);
        providerManager.setEraseCredentialsAfterAuthentication(false);

        return providerManager;
    }

//    To use In-Memory User
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.builder()
//                .username("Admin")
//                .password("$2a$10$/AZF.9Ma8uuH68QxxbeJteHOQguSpq0tek5YEu1TH.mmIxwr57Y4.")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
