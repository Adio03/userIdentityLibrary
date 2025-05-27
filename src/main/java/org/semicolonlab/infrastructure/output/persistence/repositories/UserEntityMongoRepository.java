package org.semicolonlab.infrastructure.output.persistence.repositories;

import org.semicolonlab.infrastructure.output.persistence.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntityMongoRepository extends MongoRepository<UserEntity, String> {

}
