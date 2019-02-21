package com.api.webapp.entity;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    public User(String login) {
        this.login = login;
    }

    private String login;

    @EqualsAndHashCode.Exclude
    private Set<User> followingUsr;

    public Set<User> getFollowingUsr() {
        if(followingUsr == null)
            followingUsr = new HashSet<>() ;
        return followingUsr;
    }
}
