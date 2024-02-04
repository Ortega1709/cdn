package com.ortega.scdn.services;

import com.ortega.scdn.models.Location;
import com.ortega.scdn.models.Server;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CdnServiceImpl implements CdnService {

    private GeolocationService geolocationService;
    private ServerService serverService;

    @Override
    public void findOptimalServer(String city) {
        log.info("Find optimal server");

        Server optimalServer = null;
        double optimalScore = Double.MAX_VALUE;

        List<Server> servers = serverService.getAllServers();
        Location location = geolocationService.getLocationByCityName(city);



    }


}
