package com.jd.springmvc.config.mongo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by sunboyu on 2017/10/16.
 */
@Configuration
@PropertySource("classpath:/conf/mongo.properties")
public class MongoConfig {

    @Value("${mongo.host}")
    private String HOST;

    @Value("${mongo.port}")
    private int PORT;

    @Value("${mongo.username}")
    private String USERNAME;

    @Value("${mongo.possword}")
    private String POSSWORD;

    private String DATABASE_NAME = "wuxian-center-mongo";

    @Bean
    public Mongo mongo() {
        return new MongoClient(HOST, PORT);
    }

    @Bean
    public UserCredentials userCredentials() {
        return new UserCredentials(USERNAME, POSSWORD);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), DATABASE_NAME, userCredentials());
    }
}
