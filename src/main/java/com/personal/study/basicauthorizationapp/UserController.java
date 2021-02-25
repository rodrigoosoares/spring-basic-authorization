package com.personal.study.basicauthorizationapp;

import com.personal.study.basicauthorizationapp.commons.secutiry.AuthorizationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private AuthorizationUtils authorizationUtils;


    @GetMapping
    public User getUser() {
        return User.builder()
                .id(1)
                .name("Rodrigo")
                .build();
    }

}
