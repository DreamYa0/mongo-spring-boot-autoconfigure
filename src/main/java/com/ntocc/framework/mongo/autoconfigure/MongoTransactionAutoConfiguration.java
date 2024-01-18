package com.ntocc.framework.mongo.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author dreamyao
 * @title
 * @date 2018/8/29 下午1:34
 * @since 1.0.0
 */
@Configuration
@EnableTransactionManagement
@EnableMongoRepositories(basePackages = {"com.**.mongo.**"})
public class MongoTransactionAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        // 开启 mongodb的事务
        return new MongoTransactionManager(dbFactory);
    }
}
