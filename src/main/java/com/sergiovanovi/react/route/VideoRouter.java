package com.sergiovanovi.react.route;

import com.sergiovanovi.react.handler.VideoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class VideoRouter {

    @Bean
    public RouterFunction<ServerResponse> videoRoute(VideoHandler videoHandler) {
        return RouterFunctions.route()
                .GET("/videos/{id}", videoHandler::getVideo)
                .build();

    }
}
