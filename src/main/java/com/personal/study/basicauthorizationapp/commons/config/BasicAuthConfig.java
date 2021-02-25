package com.personal.study.basicauthorizationapp.commons.config;

import com.personal.study.basicauthorizationapp.commons.secutiry.CsrfRequestMatcher;
import com.personal.study.basicauthorizationapp.commons.secutiry.entities.HttpRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static com.personal.study.basicauthorizationapp.commons.secutiry.entities.SecurityRoles.ADMIN;
import static com.personal.study.basicauthorizationapp.commons.secutiry.entities.SecurityRoles.USER;

@Configuration
@EnableWebSecurity
public class BasicAuthConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder.encode("admin"))
                .roles(ADMIN.name(), USER.name())
                .and()
                .withUser("user")
                .password(encoder.encode("user"))
                .roles(USER.name());
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


}
