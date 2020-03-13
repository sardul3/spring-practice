package com.sagar.sprrestdatademo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataBaseSourceConfig {

    @Value("${DB_URL}")
    private String dbUrl;

    @Value("${DB_PW}")
    private String dbPw;

//    @Bean
//    public DataSource getDataSource()
//    {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url(dbUrl);
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password(dbPw);
//        return dataSourceBuilder.build();
//    }

}





