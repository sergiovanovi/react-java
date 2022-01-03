package com.sergiovanovi.react.mapper;

import com.sergiovanovi.react.dto.UserDTO;
import com.sergiovanovi.react.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserEntity toEntity(UserDTO userDTO);
    UserDTO toDto(UserEntity userEntity);
}
