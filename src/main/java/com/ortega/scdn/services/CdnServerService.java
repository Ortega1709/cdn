package com.ortega.scdn.services;

import com.ortega.scdn.models.CdnServer;

import java.util.List;
import java.util.UUID;

public interface CdnServerService {

    public CdnServer saveServer(CdnServer cdnServer);
    public List<CdnServer> getAllServers();
    public CdnServer getServerById(UUID id);
    public void deleteServer(UUID id);


}
