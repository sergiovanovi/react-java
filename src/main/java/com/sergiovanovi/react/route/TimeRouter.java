package com.sergiovanovi.react.route;

import com.sergiovanovi.react.handler.TimeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TimeRouter {

    @Bean
    public RouterFunction<ServerResponse> timeRoute(TimeHandler timeHandler) {
        return RouterFunctions.route()
                .GET("/time", timeHandler::getTime)
                .build();
    }
}
