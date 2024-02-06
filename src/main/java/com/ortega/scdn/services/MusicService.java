package com.ortega.scdn.services;

import com.ortega.scdn.models.Music;
import com.ortega.scdn.models.Server;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MusicService {

    Music saveMusic(Server cdnServer);
    List<Music> getAllMusic();
    Optional<Music> getMusicById(UUID id);
    void updateMusic(Music music);
    void deleteMusic(UUID id);

}
