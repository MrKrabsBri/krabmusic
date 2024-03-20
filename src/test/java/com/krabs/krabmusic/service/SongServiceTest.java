package com.krabs.krabmusic.service;

import com.krabs.krabmusic.entity.Song;
import com.krabs.krabmusic.repository.SongRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SongServiceTest {

    @Autowired
    private SongService songService;

    @MockBean
    private SongRepository songRepository;



    @BeforeEach
    void setUp() {
       // Song song = Song.builder// 3:40:30 firstly, finish with MySQL.
    }

    @Test
    public void whenValidSongName_thenSongShouldBeFound(){
        String songName = "Poison Arrow";
        List<Song> found = songService.fetchSongByName(songName);
        for (Song song : found){
            assertEquals(songName, song.getSongName());
        }
    }
    @Test
    public void whenValidPartOfSongName_thenSongShouldBeFound(){
        String songName = "Poison Arrow";
        List<Song> found = songService.fetchSongByName("Poison");
        for (Song song : found){
            assertTrue(song.getSongName().contains("Poison"));
        }
    }
}