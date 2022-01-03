package com.sergiovanovi.react.repository;

import com.sergiovanovi.react.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {
}
