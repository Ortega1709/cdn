package com.ortega.scdn.services;

import com.ortega.scdn.models.Song;
import com.ortega.scdn.models.Server;
import com.ortega.scdn.repository.SongRepository;
import com.ortega.scdn.utils.UploadUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

    @Autowired
    @Qualifier("webApplicationContext")
    private ResourceLoader resourceLoader;
    
    private SongRepository songRepository;

    @Override
    public Song saveSong(Song song, MultipartFile file) {
        String songLink = uploadSong(file);

        // set song link
        song.setLink(songLink);
        songRepository.save(song);
        return song;
    }

    @Override
    public List<Song> getAllSongs() {
        log.info("Get all songs");
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> getSongById(UUID id) {
        log.info("Get one song");
        return songRepository.findById(id);
    }

    @Override
    public void updateSong(Song song) {
        log.info("Update song");
        songRepository.save(song);
    }

    @Override
    public void deleteSong(UUID id) {
        log.info("Delete song");

        Optional<Song> optionalSong = getSongById(id);
        if (optionalSong.isPresent()) {
            File song = new File(UploadUtil.getResourcePath() + optionalSong.get().getLink());
            song.deleteOnExit();

            songRepository.deleteById(id);
        }
    }

    private String uploadSong(MultipartFile song) {
        log.info("Upload new song");

        String songUniqueName = UploadUtil.generateUniqueSongName(Objects.requireNonNull(song.getOriginalFilename()));

        try {
            song.transferTo(new File(UploadUtil.getResourcePath() + songUniqueName));
            return songUniqueName;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
