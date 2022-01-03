package com.sergiovanovi.react.controller;

import com.sergiovanovi.react.dto.UserDTO;
import com.sergiovanovi.react.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Flux<UserDTO> getAll() {
        return userService.getAll();
    }
}
