package com.ortega.scdn.services;

import com.ortega.scdn.models.Server;

public interface CdnService {

    Server findOptimalServer(String city);

}
