package com.personal.study.basicauthorizationapp.adapters;


import com.personal.study.basicauthorizationapp.entrypoints.controllers.entities.response.UserResponse;
import com.personal.study.basicauthorizationapp.entrypoints.gateways.entities.User;

public class UserResponseAdapter {

    private UserResponseAdapter(){}

    public static UserResponse fromUser(final User user) {
        return UserResponse.builder()
            .id(user.getId())
            .username(user.getUsername())
            .roles(user.getRoles())
            .build();
    }

}
