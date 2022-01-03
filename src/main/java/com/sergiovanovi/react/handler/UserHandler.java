package com.sergiovanovi.react.handler;

import com.sergiovanovi.react.dto.UserDTO;
import com.sergiovanovi.react.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record UserHandler(UserService userService) {

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.getAll(), UserDTO.class);
    }
}
