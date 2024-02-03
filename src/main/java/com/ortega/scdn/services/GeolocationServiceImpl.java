package com.ortega.scdn.services;

import com.ortega.scdn.models.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
public class GeolocationServiceImpl implements GeolocationService {

    private static final String URL = "https://nominatim.openstreetmap.org/search?format=json&q=";

    @Override
    public Location getLocationByCityName(String city) {
        log.info("Get location by city name {}", city);
        RestTemplate restTemplate = new RestTemplate();

        try {
            Location[] response = restTemplate.getForObject(URL + city, Location[].class);
            assert response != null;
            return new Location(response[0].getLat(), response[0].getLon());
        } catch (Exception e) {
            log.error(e.toString());
        }

        return new Location(0.0, 0.0);
    }
}
