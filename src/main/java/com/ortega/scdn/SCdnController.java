package com.ortega.scdn;

import com.ortega.scdn.models.CdnServer;
import com.ortega.scdn.models.Location;
import com.ortega.scdn.services.CdnServerService;
import com.ortega.scdn.services.GeolocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SCdnController {

    @Autowired
    private GeolocationService geolocationService;
    @Autowired
    private CdnServerService cdnServerService;

    @GetMapping("/info")
    public String index() {
        return "Serveur d'origine";
    }

    @GetMapping("/location")
    public Location getLocationByCityName(@RequestParam("city") String city) {
        return geolocationService.getLocationByCityName(city);
    }

}
