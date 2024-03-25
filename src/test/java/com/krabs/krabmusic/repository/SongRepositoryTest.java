package com.krabs.krabmusic.repository;

import com.krabs.krabmusic.entity.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SongRepositoryTest {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Song song = Song.builder()
                .songName("Walking On The Moon")
                .songLength(198)
                .songDescription("from 'The Police' album 'Regatta De Blanc'")
                .songCreatedAt(LocalDate.of(1979,1,1))
                .build();

        entityManager.persist(song);
    }

    @Test
    public void whenFindById_thenReturnSong(){
        Song song = songRepository.findById(1L).get();
        assertEquals(song.getSongName(),"Walking On The Moon");
    }
    //stopped at 3:50:29 testing controlelr layer
}