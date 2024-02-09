package com.ortega.scdn.controllers;

import com.ortega.scdn.models.Server;
import com.ortega.scdn.services.ServerService;
import com.ortega.scdn.utils.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.ortega.scdn.utils.Constant.SUCCESS_MSG;

@RequestMapping("api/v1/servers")
@RestController
@AllArgsConstructor
public class ServerController {


    private ServerService serverService;

    @GetMapping("")
    public ResponseEntity<Object> getAllServers() {
        try {
            List<Server> serverResponse = serverService.getAllServers();
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, serverResponse);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> saveServer(@Validated @RequestBody Server server) {
        try {
            Server serverResponse = serverService.saveServer(server);
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.CREATED, serverResponse);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

    @PutMapping("")
    public ResponseEntity<Object> updateServer(@Validated @RequestBody Server server) {
        try {
            serverService.updateServer(server);
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getServerById(@PathVariable String id) {
        try {
            Optional<Server> serverResponse = serverService.getServerById(UUID.fromString(id));
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, serverResponse);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteServerById(@PathVariable String id) {
        try {
            serverService.deleteServer(UUID.fromString(id));
            return ResponseHandler.response(SUCCESS_MSG, HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.EXPECTATION_FAILED, null);
        }
    }

}
