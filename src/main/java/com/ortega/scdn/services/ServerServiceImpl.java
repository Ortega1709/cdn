package com.ortega.scdn.services;

import com.ortega.scdn.models.Server;
import com.ortega.scdn.repository.ServerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class ServerServiceImpl implements ServerService {

    private ServerRepository serverRepository;

    @Override
    public Server saveServer(Server server) {
        log.info("Save new server");
        return serverRepository.save(server);
    }

    @Override
    public List<Server> getAllServers() {
        log.info("Fetch all servers");
        return serverRepository.findAll();
    }

    @Override
    public Optional<Server> getServerById(UUID id) {
        log.info("Fetch one server");
        return serverRepository.findById(id);
    }

    @Override
    public void deleteServer(UUID id) {
        log.info("Delete one server");
        serverRepository.deleteById(id);
    }
}
