package com.api.webapp.dao;

import com.api.webapp.entity.Post;
import java.util.List;

public interface PostDao {

    void save(Post post);

    List<Post> findByUser(String login);
}
