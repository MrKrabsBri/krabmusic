package com.krabs.krabmusic.controller;

import com.krabs.krabmusic.entity.Song;
import com.krabs.krabmusic.error.SongNotFoundException;
import com.krabs.krabmusic.service.SongService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@WebMvcTest(SongController.class)
class SongControllerTest { //testing endpoints with WebMvcTest

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongService songService;

    private Song song;

    @BeforeEach
    void setUp() {
        song = Song.builder()
                .songName("Thank You")
                .songLength(218)
                .songDescription("from Dido album 'No Angel'")
                .songCreatedAt(LocalDate.of(1999,1,1))
                .songId(1L)
                .build();
    }

    @Test
    void saveSongs() throws Exception {
        Song inputSong = Song.builder()
                .songName("Thank You")
                .songLength(218)
                .songDescription("from Dido album 'No Angel'")
                .songCreatedAt(LocalDate.of(1999,1,1))
                .build();

        //kai paprasys info is songService, tada pamockins song ir ja grazins.
        Mockito.when(songService.saveSong(inputSong))
                .thenReturn(song);

        //TESTING POST OPERATION
        mockMvc.perform(MockMvcRequestBuilders.post("/songs")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "    \"songName\": \"Poison Arrow\",\n" +
                        "    \"songLength\": \"204\",\n" +
                        "    \"songDescription\": \"From ABC's album 'The Lexicon Of Love'\",\n" +
                        "    \"songCreatedAt\": \"1982-03-18\"" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk()); // tikimes status 200
        // MockMvcResultMatchers galima suprastinti, neliks jo jei on-demand static import padarysim
    }
//3:57:40
    @Test
    void fetchSongById() throws Exception {
        Mockito.when(songService.fetchSongById(1L))
                .thenReturn(song);

        //TESTING GET OPERATION
        mockMvc.perform(MockMvcRequestBuilders.get("/songs/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.songName")
                        .value(song.getSongName()));

    }
}