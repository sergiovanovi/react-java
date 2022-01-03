package com.sergiovanovi.react.service;

import com.sergiovanovi.react.dto.UserDTO;
import com.sergiovanovi.react.mapper.UserMapper;
import com.sergiovanovi.react.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<UserDTO> getAll() {
        return userRepository.findAll().map(userMapper::toDto);
    }
}
