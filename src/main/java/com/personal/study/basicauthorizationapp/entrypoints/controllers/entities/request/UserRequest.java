package com.personal.study.basicauthorizationapp.entrypoints.controllers.entities.request;

import com.personal.study.basicauthorizationapp.commons.secutiry.entities.SecurityRoles;

import java.util.List;

public class UserRequest {

    private String username;
    private String password;
    private List<SecurityRoles> roles;

    public UserRequest() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<SecurityRoles> getRoles() { return roles; }

    public void setRoles(List<SecurityRoles> roles) { this.roles = roles; }

    public static UserRequestBuilder builder() {
        return new UserRequestBuilder(new UserRequest());
    }

    //    Builder class
    public static class UserRequestBuilder {

        private final UserRequest userRequest;

        private UserRequestBuilder(UserRequest UserRequest) {
            this.userRequest = UserRequest;
        }

        public UserRequestBuilder username(String name) {
            userRequest.setUsername(name);
            return this;
        }

        public UserRequestBuilder password(String password) {
            userRequest.setPassword(password);
            return this;
        }

        public UserRequestBuilder roles(List<SecurityRoles> roles) {
            userRequest.setRoles(roles);
            return this;
        }

        public UserRequest build() {
            return userRequest;
        }
    }

}
