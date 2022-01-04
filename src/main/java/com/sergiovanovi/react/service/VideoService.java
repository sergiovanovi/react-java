package com.sergiovanovi.react.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public record VideoService(ResourceLoader resourceLoader) {

    private static final String FORMAT = "classpath:videos/%s.mp4";

    public Mono<Resource> getVideo(String id) {
        return Mono.fromSupplier(() -> this.resourceLoader.getResource(String.format(FORMAT, id)));
    }
}
