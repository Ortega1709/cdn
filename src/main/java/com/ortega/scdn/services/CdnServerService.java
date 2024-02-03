package com.ortega.scdn.services;

import com.ortega.scdn.models.CdnServer;

import java.util.List;
import java.util.UUID;

public interface CdnServerService {

    CdnServer saveServer(CdnServer cdnServer);
    List<CdnServer> getAllServers();
    CdnServer getServerById(UUID id);
    void deleteServer(UUID id);


}
