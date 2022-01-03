package com.sergiovanovi.react.repository;

import com.sergiovanovi.react.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {

    Flux<UserEntity> findByIdNotNull(Pageable pageable);
}
