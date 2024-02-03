package com.ortega.scdn.repository;

import com.ortega.scdn.models.CdnServer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static com.ortega.scdn.utils.Constants.SERVER_HASH_KEY;

@Repository
public class CdnServerRepository {



    public CdnServer saveServer(CdnServer cdnServer) {
        return cdnServer;
    }

    public List<CdnServer> getAllServers() {
        return List.of();
    }

    public CdnServer getServerById(UUID id) {
        return new CdnServer();
    }

    public void deleteServer(UUID id) {}

}
