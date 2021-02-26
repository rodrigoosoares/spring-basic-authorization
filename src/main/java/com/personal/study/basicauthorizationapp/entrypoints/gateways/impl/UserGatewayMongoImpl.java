package com.personal.study.basicauthorizationapp.entrypoints.gateways.impl;

import com.personal.study.basicauthorizationapp.entrypoints.gateways.UserGateway;
import com.personal.study.basicauthorizationapp.entrypoints.gateways.entities.User;
import com.personal.study.basicauthorizationapp.entrypoints.gateways.repositories.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserGatewayMongoImpl implements UserGateway {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Override
    public Optional<User> getUserInfoByUsername(String username) {
        return userMongoRepository.findByUsername(username);
    }

    public void createUser(final User user) {
        userMongoRepository.createUser(user);
    }


}
