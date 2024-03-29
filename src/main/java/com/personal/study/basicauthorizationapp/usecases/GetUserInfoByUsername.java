package com.personal.study.basicauthorizationapp.usecases;

import com.personal.study.basicauthorizationapp.commons.excepetions.UserNotFoundException;
import com.personal.study.basicauthorizationapp.entrypoints.gateways.UserGateway;
import com.personal.study.basicauthorizationapp.entrypoints.gateways.entities.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetUserInfoByUsername {

    private final UserGateway userGateway;

    public GetUserInfoByUsername(UserGateway userGateway) {

        this.userGateway = userGateway;
    }

    public User execute(final String username) {

        final Optional<User> userOpt = userGateway.getUserInfoByUsername(username);

        if(userOpt.isPresent()) {
            return userOpt.get();
        }

        throw new UserNotFoundException();
    }

}
