package com.api.webapp.service;

import com.api.webapp.dao.PostDao;
import com.api.webapp.entity.Post;
import com.api.webapp.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PostService extends AbstractService{

    private PostDao postDao;

    @Autowired
    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public void postMessage(Post post){
        this.registerUser(post.getUser().getLogin());
        this.postDao.save(post);
    }

    public List<Post> getUserPosts(String login){
        return postDao.findByUser(login);
    }

    public List<Post> getFollowersPosts(User user){
        List<Post> posts = new LinkedList<>();
        user.getFollowingUsr().stream().forEach(s -> posts.addAll(postDao.findByUser(s.getLogin())));
        return posts;
    }
}
