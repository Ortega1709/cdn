package com.ortega.scdn.repository;


import com.ortega.scdn.models.Music;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MusicRepository extends MongoRepository<Music, UUID> {

}
