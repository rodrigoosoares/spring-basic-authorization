package com.personal.study.basicauthorizationapp;

public class User {

    private Integer id;
    private String name;

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static UserBuilder builder() {
        return new UserBuilder(new User());
    }

}


class UserBuilder {

    private final User user;

    public UserBuilder(User user) {
        this.user = user;
    }

    public UserBuilder id(Integer id) {
        user.setId(id);
        return this;
    }

    public UserBuilder name(String name) {
        user.setName(name);
        return this;
    }

    public User build() {
        return user;
    }


}