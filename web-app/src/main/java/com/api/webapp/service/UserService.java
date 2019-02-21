package com.api.webapp.service;

import com.api.webapp.entity.User;
import com.api.webapp.validation.ValidationException;
import org.springframework.stereotype.Service;


@Service
public class UserService extends AbstractService{

    public void follow(String user1, String user2){
        if(user1.equals(user2))
            throw new ValidationException("User can't follow himself");
         this.findUser(user1).getFollowingUsr().add(this.findUser(user2));
    }


    public User findUser(String login){
        return this.userDao.find(login).orElseThrow(() ->  new ValidationException( "User '" + login + "' have to make a post first"));
    }


}
