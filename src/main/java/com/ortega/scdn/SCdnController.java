package com.ortega.scdn;

import com.ortega.scdn.models.Location;
import com.ortega.scdn.models.Server;
import com.ortega.scdn.services.CdnService;
import com.ortega.scdn.services.GeolocationServiceImpl;
import com.ortega.scdn.services.ServerServiceImpl;
import com.ortega.scdn.utils.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.ortega.scdn.utils.Constant.SUCCESS_MSG;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class SCdnController {

    private final GeolocationServiceImpl geolocationService;
    private final CdnService cdnService;
    private final ServerServiceImpl serverService;

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

    @GetMapping("/servers")
    public ResponseEntity<Object> getAllServers() {
        try {
            List<Server> serverResponse = serverService.getAllServers();
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, serverResponse);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

    @PostMapping("/servers")
    public ResponseEntity<Object> saveServer(@Validated @RequestBody Server server) {
        try {
            Server serverResponse = serverService.saveServer(server);
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.CREATED, serverResponse);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

    @PutMapping("/servers")
    public ResponseEntity<Object> updateServer(@Validated @RequestBody Server server) {
        try {
            serverService.updateServer(server);
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

    @GetMapping("/servers/{id}")
    public ResponseEntity<Object> getServerById(@PathVariable String id) {
        try {
            Optional<Server> serverResponse = serverService.getServerById(UUID.fromString(id));
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, serverResponse);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }
    @DeleteMapping("/servers/{id}")
    public ResponseEntity<Object> deleteServerById(@PathVariable String id) {
        try {
            serverService.deleteServer(UUID.fromString(id));
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

    @GetMapping("/proxy")
    public ResponseEntity<String> getMovieById() {
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "xxxxx");

            HttpEntity<String> httpEntity = new HttpEntity<>(headers);
            return restTemplate.exchange("http://localhost:8085/api/v1/info", HttpMethod.GET, httpEntity, String.class);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

}
