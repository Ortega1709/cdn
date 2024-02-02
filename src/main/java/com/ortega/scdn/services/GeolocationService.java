package com.ortega.scdn.services;

import com.ortega.scdn.models.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class GeolocationService {

    private static final String url = "https://nominatim.openstreetmap.org/search?format=json&q=";

    public Location getLocationByCityName(String city) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            Location[] response = restTemplate.getForObject(url + city, Location[].class);
            assert response != null;
            return new Location(response[0].getLatitude(), response[0].getLongitude());
        } catch (Exception e) {
            log.error("[Error] ", e);
        }

        return new Location(0.0, 0.0);
    }
}
