package com.ortega.scdn.services;

import com.ortega.scdn.models.Server;
import com.ortega.scdn.repository.ServerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.ortega.scdn.utils.Constant.MAX_BANDWIDTH;
import static com.ortega.scdn.utils.Constant.SERVER_CACHE;

@Slf4j
@Service
@AllArgsConstructor
public class ServerServiceImpl implements ServerService {

    private ServerRepository serverRepository;

    @Override
    @CacheEvict(value = SERVER_CACHE, allEntries = true)
    public Server saveServer(Server server) {
        log.info("Save new server");
        return serverRepository.save(server);
    }

    @Override
    @Cacheable(SERVER_CACHE)
    public List<Server> getAllServers() {
        log.info("Fetch all servers");
        return serverRepository.findAll();
    }

    @Override
    @Cacheable(SERVER_CACHE)
    public Optional<Server> getServerById(UUID id) {
        log.info("Fetch one server");
        return serverRepository.findById(id);
    }

    @Override
    @CacheEvict(value = SERVER_CACHE, allEntries = true)
    public void updateServer(Server server) {
        server.setAvailable(!(server.getBandwidth() >= MAX_BANDWIDTH));

        log.info("Update one server");
        serverRepository.save(server);
    }

    @Override
    @CacheEvict(value = SERVER_CACHE, allEntries = true)
    public void deleteServer(UUID id) {
        log.info("Delete one server");
        serverRepository.deleteById(id);
    }
}
