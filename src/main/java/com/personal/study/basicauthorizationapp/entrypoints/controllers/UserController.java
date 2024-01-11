package com.personal.study.basicauthorizationapp.entrypoints.controllers;

import com.personal.study.basicauthorizationapp.adapters.UserAdapter;
import com.personal.study.basicauthorizationapp.adapters.UserResponseAdapter;
import com.personal.study.basicauthorizationapp.entrypoints.controllers.entities.request.UserRequest;
import com.personal.study.basicauthorizationapp.entrypoints.controllers.entities.response.UserResponse;
import com.personal.study.basicauthorizationapp.entrypoints.gateways.UserGateway;
import com.personal.study.basicauthorizationapp.usecases.GetUserInfoByUsername;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.personal.study.basicauthorizationapp.commons.constants.RolesConstants.ROLE_ADMIN;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserGateway userGateway;

    private final GetUserInfoByUsername getUserInfoByUsername;


    public UserController(UserGateway userGateway, GetUserInfoByUsername getUserInfoByUsername) {

        this.userGateway = userGateway;
        this.getUserInfoByUsername = getUserInfoByUsername;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserInfoByUsername(@RequestParam final String username) {
        return UserResponseAdapter.fromUser(getUserInfoByUsername.execute(username));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured(ROLE_ADMIN)
    public void createUser(@RequestBody final UserRequest userRequest) {
        userGateway.createUser(
            UserAdapter.fromUserRequest(userRequest)
        );
    }

}
