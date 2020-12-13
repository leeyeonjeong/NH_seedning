package com.NH.seedning.User.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private int id;
    private String name;
    private String username;
    private String email;
    private Long myseed;

    public SessionUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.myseed = user.getMyseed();
    }
}
