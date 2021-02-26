package com.personal.study.basicauthorizationapp.adapters;

import com.personal.study.basicauthorizationapp.entrypoints.controllers.entities.request.UserRequest;
import com.personal.study.basicauthorizationapp.entrypoints.gateways.entities.User;

public class UserAdapter {

    private UserAdapter() {}

    public static User fromUserRequest(final UserRequest userRequest) {
        return User.builder()
            .username(userRequest.getUsername())
            .password(userRequest.getPassword())
            .roles(userRequest.getRoles())
            .build();
    }
}
