package com.api.webapp.dao;

import com.api.webapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void save(User user);

    Optional<User> find(String login);

}
