package com.api.webapp.datasource;

import com.api.webapp.entity.Post;
import com.api.webapp.entity.User;
import lombok.Getter;

import java.util.*;

@Getter
public class DataSource {

    private Map<Post, User> postDatasource;
    private Map<String,User> userDatasource;

    public DataSource() {
        this.postDatasource = new HashMap<>();
        this.userDatasource = new HashMap<>();
    }
}
