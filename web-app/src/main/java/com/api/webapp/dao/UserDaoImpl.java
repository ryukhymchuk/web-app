package com.api.webapp.dao;

import com.api.webapp.datasource.DataSource;
import com.api.webapp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{

    private Map<String, User> dataSource;

    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource.getUserDatasource();
    }

    @Override
    public void save(User user) {
        dataSource.put(user.getLogin(),user);
    }

    @Override
    public Optional<User> find(String login) {
        return Optional.ofNullable(dataSource.get(login));
    }

}
