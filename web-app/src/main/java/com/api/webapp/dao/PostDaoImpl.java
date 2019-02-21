package com.api.webapp.dao;

import com.api.webapp.datasource.DataSource;
import com.api.webapp.entity.Post;
import com.api.webapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostDaoImpl implements PostDao{

    private Map<Post, User> dataSource;

    @Autowired
    public PostDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource.getPostDatasource();
    }

    @Override
    public void save(Post post) {
         dataSource.put(post, post.getUser());
    }

    @Override
    public List<Post> findByUser(String login) {
        return this.dataSource.entrySet()
                              .stream()
                              .filter(entry -> entry.getValue().getLogin().equals(login))
                              .map(entry -> entry.getKey())
                              .collect(Collectors.toList());
    }
}
