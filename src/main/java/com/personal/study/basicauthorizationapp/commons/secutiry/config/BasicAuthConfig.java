package com.personal.study.basicauthorizationapp.commons.secutiry.config;

import com.personal.study.basicauthorizationapp.commons.secutiry.CsrfRequestMatcher;
import com.personal.study.basicauthorizationapp.commons.secutiry.entities.HttpRequest;
import com.personal.study.basicauthorizationapp.commons.secutiry.services.MongoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class BasicAuthConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MongoUserDetailsService mongoUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mongoUserDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        final RequestMatcher csrfRequestMatcher = new CsrfRequestMatcher(new HttpRequest("/user", "POST"));

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Remove auth cache
            .and()
                .csrf()
                .ignoringRequestMatchers(csrfRequestMatcher) // Ignore csrf security for request matchers
            .and()
                .authorizeRequests().anyRequest().authenticated()
            .and()
                .httpBasic(); // Enable basic authentication
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
