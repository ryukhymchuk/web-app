package com.api.webapp.conf;

import com.api.webapp.datasource.DataSource;
import com.api.webapp.entity.Post;
import com.api.webapp.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Configuration
public class Config {

    @Bean
    public DataSource dataSource(){
        return new DataSource();
    }
}
