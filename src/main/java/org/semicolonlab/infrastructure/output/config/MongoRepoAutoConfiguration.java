package org.semicolonlab.infrastructure.output.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ConditionalOnClass(name = "org.springframework.data.mongodb.core.MongoTemplate")
@EnableMongoRepositories(
        basePackages = "org.semicolonlab.infrastructure.output.persistence.repositories")
public class MongoRepoAutoConfiguration {}

