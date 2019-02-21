package com.api.webapp.service;

import com.api.webapp.dao.UserDao;
import com.api.webapp.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public abstract class AbstractService {

    @Autowired
    protected UserDao userDao;

    public void registerUser(String user){
        this.userDao.save(new User(user));
    }
}
