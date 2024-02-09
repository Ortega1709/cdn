package com.ortega.scdn.services;

import com.ortega.scdn.utils.UploadUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.ortega.scdn.utils.Constant.*;

@Slf4j
@Service
public class StreamServiceImpl implements StreamService {

    @Autowired
    @Qualifier("webApplicationContext")
    private ResourceLoader resourceLoader;


    @Override
    public Mono<Resource> getSong(String link) {
        log.info("Stream song {}", link);
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(SONG_FORMAT, link + SONG_EXTENSION)));
    }

}
