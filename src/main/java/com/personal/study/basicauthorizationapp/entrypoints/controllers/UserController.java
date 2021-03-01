package com.personal.study.basicauthorizationapp.entrypoints.controllers;

import com.personal.study.basicauthorizationapp.adapters.UserAdapter;
import com.personal.study.basicauthorizationapp.adapters.UserResponseAdapter;
import com.personal.study.basicauthorizationapp.commons.secutiry.AuthorizationUtils;
import com.personal.study.basicauthorizationapp.entrypoints.controllers.entities.request.UserRequest;
import com.personal.study.basicauthorizationapp.entrypoints.controllers.entities.response.UserResponse;
import com.personal.study.basicauthorizationapp.usecases.CreateUser;
import com.personal.study.basicauthorizationapp.usecases.GetUserInfoByUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static com.personal.study.basicauthorizationapp.commons.constants.RolesConstants.ROLE_ADMIN;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthorizationUtils authorizationUtils;

    @Autowired
    private CreateUser createUser;

    @Autowired
    private GetUserInfoByUsername getUserInfoByUsername;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserInfoByUsername(@RequestParam final String username) {
        return UserResponseAdapter.fromUser(getUserInfoByUsername.execute(username));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured(ROLE_ADMIN)
    public void createUser(@RequestBody final UserRequest userRequest) {
        createUser.execute(
            UserAdapter.fromUserRequest(userRequest)
        );
    }

}
