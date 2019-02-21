package com.api.webapp;

import com.api.webapp.dao.UserDao;
import com.api.webapp.entity.User;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest extends WebAppApplicationTests {

    @Autowired
    private UserDao userDao;

    List<User> users;

    @Before
    public void setUp(){
        this.dataSource.getUserDatasource().clear();
        users = new ArrayList<>();
        users.add(new User("user1"));
        users.add(new User("user1"));
        users.add(new User("user2"));
        users.add(new User("user2"));
        users.add(new User("user3"));
    }

    public void testSave(){
       users.forEach(this.userDao::save);
       assertEquals(3, this.dataSource.getUserDatasource().size());
    }

}
