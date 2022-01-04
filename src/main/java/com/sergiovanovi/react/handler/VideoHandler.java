package com.sergiovanovi.react.handler;

import com.sergiovanovi.react.service.VideoService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record VideoHandler(VideoService videoService) {

    public Mono<ServerResponse> getVideo(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.valueOf("videos/mp4"))
                .body(videoService.getVideo(id), Resource.class);
    }
}
