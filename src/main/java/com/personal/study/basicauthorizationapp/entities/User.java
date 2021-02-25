package com.personal.study.basicauthorizationapp.entities;

import com.personal.study.basicauthorizationapp.commons.secutiry.entities.SecurityRoles;

import java.util.List;

public class User {

    private Integer id;
    private String username;
    private String password;
    private List<SecurityRoles> roles;

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public static UserBuilder builder() {
        return new UserBuilder(new User());
    }


//    Builder class
    public static class UserBuilder {

        private final User user;

        private UserBuilder(User user) {
            this.user = user;
        }

        public UserBuilder id(Integer id) {
            user.setId(id);
            return this;
        }

        public UserBuilder name(String name) {
            user.setUsername(name);
            return this;
        }

        public UserBuilder password(String password) {
            user.setPassword(password);
            return this;
        }

        public User build() {
            return user;
        }
    }
}