package com.personal.study.basicauthorizationapp.entrypoints.gateways;

import com.personal.study.basicauthorizationapp.entrypoints.gateways.entities.User;

import java.util.Optional;

public interface UserGateway {

    Optional<User> getUserInfoByUsername(String username);

    void createUser(User user);

}
