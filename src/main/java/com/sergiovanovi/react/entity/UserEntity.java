package com.sergiovanovi.react.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("USERS")
public class UserEntity {

    @Id
    private Long id;
    private String name;
}


