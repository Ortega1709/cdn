package com.ortega.scdn.controllers;

import com.ortega.scdn.models.Location;
import com.ortega.scdn.models.Server;
import com.ortega.scdn.services.*;
import com.ortega.scdn.utils.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import static com.ortega.scdn.utils.Constant.SUCCESS_MSG;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class SCdnController {

    private final GeolocationServiceImpl geolocationService;
    private final StreamService streamService;
    private final CdnService cdnService;

    @GetMapping("/info")
    public String index() {
        return "Serveur d'origine";
    }

    @GetMapping("/location")
    public ResponseEntity<Object> getLocationByCityName(@RequestParam("city") String city) {
        try {
            Location locationResponse = geolocationService.getLocationByCityName(city);
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, locationResponse);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

    @GetMapping("/servers/optimal")
    public ResponseEntity<Object> getOptimalServerByCityName(@RequestParam("city") String city) {
        try {
            Server cdnResponse = cdnService.findOptimalServer(city);
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, cdnResponse);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

    @GetMapping("/proxy")
    public ResponseEntity<String> getSongByLinkAndCity(@RequestParam("link") String link, @RequestParam("city") String city) {
        try {

            Server optimalServer = cdnService.findOptimalServer(city);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            HttpEntity<String> httpEntity = new HttpEntity<>(headers);
            String url = optimalServer.getAddress() + "api/v1/info";
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
