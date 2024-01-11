package com.personal.study.basicauthorizationapp.adapters;

import com.personal.study.basicauthorizationapp.entrypoints.controllers.entities.request.UserRequest;
import com.personal.study.basicauthorizationapp.entrypoints.gateways.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserAdapter {

    private UserAdapter() {}

    public static User fromUserRequest(final UserRequest userRequest) {
        return User.builder()
            .username(userRequest.getUsername())
            .password(new BCryptPasswordEncoder().encode(userRequest.getPassword()))
            .roles(userRequest.getRoles())
            .build();
    }
}
