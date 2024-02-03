package com.ortega.scdn.services;

import com.ortega.scdn.models.CdnServer;
import com.ortega.scdn.repository.CdnServerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CdnServiceServiceImpl implements CdnServerService {

    @Autowired
    private CdnServerRepository cdnServerRepository;

    @Override
    public CdnServer saveServer(CdnServer cdnServer) {
        log.info("Save new server");
        return cdnServerRepository.saveServer(cdnServer);
    }

    @Override
    public List<CdnServer> getAllServers() {
        log.info("Fetch all servers");
        return cdnServerRepository.getAllServers();
    }

    @Override
    public CdnServer getServerById(UUID id) {
        log.info("Fetch one server");
        return cdnServerRepository.getServerById(id);
    }

    @Override
    public void deleteServer(UUID id) {
        log.info("Delete one server");
        cdnServerRepository.deleteServer(id);
    }
}
