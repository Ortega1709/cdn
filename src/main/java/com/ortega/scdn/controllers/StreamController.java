package com.ortega.scdn.controllers;

import com.ortega.scdn.models.Server;
import com.ortega.scdn.services.CdnService;
import com.ortega.scdn.services.GeolocationService;
import com.ortega.scdn.services.StreamService;
import com.ortega.scdn.utils.ResponseHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import static com.ortega.scdn.utils.Constant.SUCCESS_MSG;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/")
public class StreamController {

    private final StreamService streamService;
    private final CdnService cdnService;

    @GetMapping("proxy/stream")
    public ResponseEntity<Object> getSongByLinkAndCity(@RequestParam("link") String link, @RequestParam("city") String city) {
        try {
            Server optimalServer = cdnService.findOptimalServer(city);

            String url = optimalServer.getAddress() + "api/v1/stream/songs?link=" + link;
            log.info("[SERVER] " + url);
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, url);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("proxy/songs")
    public ResponseEntity<String> getAllSongByCity(@RequestParam("city") String city) {
        try {
            Server optimalServer = cdnService.findOptimalServer(city);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            HttpEntity<String> httpEntity = new HttpEntity<>(headers);
            String url = optimalServer.getAddress() + "api/v1/songs";
            return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }



    @GetMapping(value = "/stream/songs", produces = "audio/mp3")
    public Mono<Resource> getSongByLink(@RequestParam("link") String link) {
        return streamService.getSong(link);
    }

}
