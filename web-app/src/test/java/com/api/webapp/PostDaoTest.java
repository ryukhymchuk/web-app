package com.api.webapp;

import com.api.webapp.dao.PostDao;
import com.api.webapp.datasource.DataSource;
import com.api.webapp.entity.Post;
import com.api.webapp.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class PostDaoTest extends WebAppApplicationTests{

    @Autowired
    private PostDao postDao;

    private List<Post> posts;
    private User user;

    @Before
    public void setUp(){
        dataSource.getPostDatasource().clear();
        this.user = new User("user1");
        posts = new ArrayList<>();
        Post post1 = new Post();
        post1.setUser( this.user);
        posts.add(post1);
        Post post2 = new Post();
        post2.setUser( this.user);
        posts.add(post2);
        Post post3 = new Post();
        post3.setUser( this.user);
        posts.add(post3);

    }

    @Test
    public void testPost(){
        posts.forEach(this::postMessage);
        assertEquals(3, postDao.findByUser(this.user.getLogin()).size());
    }

    private void postMessage(Post post){
        postDao.save(post);
        System.out.println(post);
    }

}
