package com.krabs.krabmusic.service;

import com.krabs.krabmusic.entity.Song;
import com.krabs.krabmusic.error.SongNotFoundException;
import com.krabs.krabmusic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;
    @Override
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public List<Song> fetchSongList() {
        return songRepository.findAll();
    }

    @Override
    public Song fetchSongById(Long songId) throws SongNotFoundException {
        Optional<Song> song = songRepository.findById(songId);//.get()

        if (!song.isPresent()){
            throw new SongNotFoundException("Song Not Available");
        }
        return song.get();
    }

    @Override
    public void deleteSongById(Long songId) {
        songRepository.deleteById(songId);
    }

    @Override
    public Song updateSong(Long songId, Song song) {
        Song songUpdated = songRepository.findById(songId).get();
        Long durationZeroSeconds = Duration.ofSeconds(0).toSeconds();

        if (Objects.nonNull(song.getSongName()) &&
                !"".equalsIgnoreCase(song.getSongName())) {

            songUpdated.setSongName(song.getSongName());
        }

        if (Objects.nonNull(song.getSongLength()) &&
                !((song.getSongLength() ==0))) {

            songUpdated.setSongLength(song.getSongLength());
        }

        if (Objects.nonNull(song.getSongDescription()) &&
                !"".equalsIgnoreCase(song.getSongDescription())) {

            songUpdated.setSongDescription(song.getSongDescription());
        }

        if (Objects.nonNull(song.getSongCreatedAt()) &&
                !((song.getSongCreatedAt().getYear() < 1000))) {

            songUpdated.setSongCreatedAt(song.getSongCreatedAt());
        }

        return songRepository.save(songUpdated);
    }

    @Override
    public Song fetchSongByName(String songName) {
        return songRepository.findBySongNameIgnoreCase(songName);
    }
}
