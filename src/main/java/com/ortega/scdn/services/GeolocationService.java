package com.ortega.scdn.services;


import com.ortega.scdn.models.Location;

public interface GeolocationService {

    Location getLocationByCityName(String city);

}
