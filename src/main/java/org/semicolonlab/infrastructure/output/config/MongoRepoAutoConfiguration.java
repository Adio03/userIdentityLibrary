package org.semicolonlab.infrastructure.output.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ConditionalOnClass(MongoTemplate.class)
@EnableMongoRepositories(
        basePackages = "org.semicolonlab.infrastructure.output.persistence.repositories")
@Slf4j
public class MongoRepoAutoConfiguration {
    @PostConstruct
    public void init() {
        log.info(" MongoRepoAutoConfiguration loaded!");
    }

}

