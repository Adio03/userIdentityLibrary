package org.semicolonlab.infrastructure.output.persistence.repositories;

import org.semicolonlab.infrastructure.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityJpaRepository  extends  JpaRepository<UserEntity,String> {
}
