package com.ortega.scdn.controllers;

import com.ortega.scdn.models.Location;
import com.ortega.scdn.services.GeolocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SCdnController {

    @Autowired
    private GeolocationService geolocationService;

    @GetMapping("/info")
    public String index() {
        return "Serveur d'origine";
    }

    @GetMapping("/location")
    public Location getLocationByCityName(@RequestParam("city") String city) {
        return geolocationService.getLocationByCityName(city);
    }

}
