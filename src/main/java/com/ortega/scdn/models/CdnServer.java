package com.ortega.scdn.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

import static com.ortega.scdn.utils.Constants.SERVER_HASH_KEY;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(SERVER_HASH_KEY)
public class CdnServer implements Serializable {

    @Id
    private UUID id;
    private String name;
    private double latency;
    private Location location;

}
