package com.personal.study.basicauthorizationapp.entrypoints.controllers.entities.response;

import com.personal.study.basicauthorizationapp.commons.security.entities.SecurityRoles;

import java.util.List;

public class UserResponse {

    private String id;
    private String username;
    private List<SecurityRoles> roles;

    public UserResponse() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<SecurityRoles> getRoles() { return roles; }

    public void setRoles(List<SecurityRoles> roles) { this.roles = roles; }

    public static UserResponseBuilder builder() {
        return new UserResponseBuilder(new UserResponse());
    }

    //    Builder class
    public static class UserResponseBuilder {

        private final UserResponse userResponse;

        private UserResponseBuilder(UserResponse userResponse) {
            this.userResponse = userResponse;
        }

        public UserResponseBuilder id(String id) {
            userResponse.setId(id);
            return this;
        }

        public UserResponseBuilder username(String name) {
            userResponse.setUsername(name);
            return this;
        }

        public UserResponseBuilder roles(List<SecurityRoles> roles) {
            userResponse.setRoles(roles);
            return this;
        }

        public UserResponse build() {
            return userResponse;
        }
    }

}
