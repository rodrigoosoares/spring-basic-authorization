package com.personal.study.basicauthorizationapp.usecases;

import com.personal.study.basicauthorizationapp.commons.secutiry.entities.SecurityRoles;
import com.personal.study.basicauthorizationapp.entities.User;
import com.personal.study.basicauthorizationapp.entrypoints.gateways.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateUser {

    @Autowired
    private UserGateway userGateway;

    public void execute(final User user) {
        addUserDefaultRole(user);
        userGateway.createUser(user);
    }

    private void addUserDefaultRole(final User user) {
        user.setRoles(
            List.of(SecurityRoles.USER)
        );
    }

}
