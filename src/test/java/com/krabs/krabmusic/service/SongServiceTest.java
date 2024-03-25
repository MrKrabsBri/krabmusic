package com.krabs.krabmusic.service;

import com.krabs.krabmusic.entity.Song;
import com.krabs.krabmusic.repository.SongRepository;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
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
       Song song =
               Song.builder()
                       .songName("Toxic")
                       .songLength(198)
                       .songDescription("from album 'In the zone'")
                       .songCreatedAt(LocalDate.of(2003,1,1))
                       .build();

       //kai paprasys info is songRepository, tada pamockins song ir ja grazins.
        Mockito.when(songRepository.findBySongNameIgnoreCase("Toxic"))
                .thenReturn(song);
    }

    @Test
    @DisplayName("Get Data based on Valid Song Name")
    public void whenValidSongName_thenSongShouldBeFound(){
        String songName = "Toxic";
        Song found = songService.fetchSongByName(songName);
        assertNotNull(found);
        //List<Song> found = songService.fetchSongByName(songName);
        //Song firstSong = found.get(0);
        assertEquals(songName, found.getSongName());
//        for (Song song : found){
//            assertEquals(songName, song.getSongName());
//        }
    }
    @Test
    @DisplayName("Get song from part of the Name")
    @Disabled
    // modify test later
    public void whenValidPartOfSongName_thenSongShouldBeFound(){
        String songSnippet = "Tox";
        Song found = songService.fetchSongByName("Toxic");
            assertTrue(found.getSongName().contains(songSnippet));
    }
}