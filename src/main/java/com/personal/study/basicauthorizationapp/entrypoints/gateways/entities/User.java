package com.personal.study.basicauthorizationapp.entrypoints.gateways.entities;

import com.personal.study.basicauthorizationapp.commons.security.entities.SecurityRoles;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("user")
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private List<SecurityRoles> roles;

    public User() {}

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

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<SecurityRoles> getRoles() { return roles; }

    public void setRoles(List<SecurityRoles> roles) { this.roles = roles; }

    public static UserBuilder builder() {
        return new UserBuilder(new User());
    }

    @Override
    public String toString() {
        return "User{" +
            "id='" + id + '\'' +
            ", username='" + username + '\'' +
            ", password=[PROTECTED] " +
            ", roles=" + roles +
            '}';
    }

    //    Builder class
    public static class UserBuilder {

        private final User user;

        private UserBuilder(User user) {
            this.user = user;
        }

        public UserBuilder id(String id) {
            user.setId(id);
            return this;
        }

        public UserBuilder username(String name) {
            user.setUsername(name);
            return this;
        }

        public UserBuilder password(String password) {
            user.setPassword(password);
            return this;
        }

        public UserBuilder roles(List<SecurityRoles> roles) {
            user.setRoles(roles);
            return this;
        }

        public User build() {
            return user;
        }
    }
}