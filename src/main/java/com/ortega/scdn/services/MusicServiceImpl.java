package com.ortega.scdn.services;

import com.ortega.scdn.models.Music;
import com.ortega.scdn.models.Server;
import com.ortega.scdn.repository.MusicRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class MusicServiceImpl implements MusicService {

    private MusicRepository musicRepository;

    @Override
    public Music saveMusic(Server cdnServer) {
        return null;
    }

    @Override
    public List<Music> getAllMusic() {
        return null;
    }

    @Override
    public Optional<Music> getMusicById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void updateMusic(Music music) {

    }

    @Override
    public void deleteMusic(UUID id) {

    }
}
