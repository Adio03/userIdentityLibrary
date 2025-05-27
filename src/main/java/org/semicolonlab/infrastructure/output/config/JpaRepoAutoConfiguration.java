package org.semicolonlab.infrastructure.output.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ConditionalOnClass(name = "jakarta.persistence.EntityManager")
@EnableJpaRepositories(
        basePackages = "org.semicolonlab.infrastructure.output.persistence.repositories")
public class JpaRepoAutoConfiguration {}

