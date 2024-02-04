package com.ortega.scdn.services;

import com.ortega.scdn.models.Server;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServerService {

    Server saveServer(Server cdnServer);
    List<Server> getAllServers();
    Optional<Server> getServerById(UUID id);
    void updateServer(Server server);
    void deleteServer(UUID id);


}
