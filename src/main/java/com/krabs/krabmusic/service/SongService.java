package com.krabs.krabmusic.service;

import com.krabs.krabmusic.entity.Song;
import com.krabs.krabmusic.error.SongNotFoundException;

import java.util.List;

public interface SongService {
    public Song saveSong(Song song);

    public List<Song> fetchSongList();

    public Song fetchSongById(Long songId) throws SongNotFoundException;

    public void deleteSongById(Long songId);

    public Song updateSong(Long songId, Song song);

    public Song fetchSongByName(String songName);
}
