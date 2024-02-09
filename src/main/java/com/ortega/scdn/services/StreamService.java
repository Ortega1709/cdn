package com.ortega.scdn.services;

import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

public interface StreamService {

    Mono<Resource> getSong(String link);

}
