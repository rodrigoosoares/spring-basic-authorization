package com.personal.study.basicauthorizationapp.commons.security;

import com.personal.study.basicauthorizationapp.commons.security.entities.HttpRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.List;

public class CsrfRequestMatcher implements RequestMatcher {

    private final List<AntPathRequestMatcher> requestMatchers;

    public CsrfRequestMatcher(final HttpRequest... requests) {
        requestMatchers = new ArrayList<>();

        for (HttpRequest request : requests) {
            requestMatchers.add(new AntPathRequestMatcher(request.getEndpoint(), request.getHttpMethod()));
        }
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return requestMatchers.stream().anyMatch(requestMatcher -> requestMatcher.matches(request));
    }
}
