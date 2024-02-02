package com.ortega.scdn.repository;

import com.ortega.scdn.models.CdnServer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static com.ortega.scdn.utils.Constants.SERVER_HASH_KEY;

@Repository
public class CdnServerRepository {


    private RedisTemplate<String, Object> redisTemplate;

    public CdnServer saveServer(CdnServer cdnServer) {
        redisTemplate.opsForHash().put(SERVER_HASH_KEY, cdnServer.getId(), cdnServer);
        return cdnServer;
    }

    public List<Object> getAllServers() {
        return redisTemplate.opsForHash().values(SERVER_HASH_KEY);
    }

    public CdnServer getServerById(UUID id) {
        return (CdnServer) redisTemplate.opsForHash().get(SERVER_HASH_KEY, id);
    }

    public void deleteServer(UUID id) {
        redisTemplate.opsForHash().delete(SERVER_HASH_KEY, id);
    }

}
