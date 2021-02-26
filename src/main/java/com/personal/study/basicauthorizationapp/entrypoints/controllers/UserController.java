package com.personal.study.basicauthorizationapp.entrypoints.controllers;

import com.personal.study.basicauthorizationapp.entities.User;
import com.personal.study.basicauthorizationapp.commons.secutiry.AuthorizationUtils;
import com.personal.study.basicauthorizationapp.commons.secutiry.exceptions.ForbiddenHttpAccessException;
import com.personal.study.basicauthorizationapp.usecases.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthorizationUtils authorizationUtils;

    @Autowired
    private CreateUser createUser;

    @GetMapping
    public User getUser() {
        return User.builder()
                .id("1")
                .name("Rodrigo")
                .build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createUser(@RequestBody final User user) {
        if(authorizationUtils.isAdmin()) {
            createUser.execute(user);
        } else {
            throw new ForbiddenHttpAccessException();
        }
    }

}
