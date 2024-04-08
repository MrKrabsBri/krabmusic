package com.krabs.krabmusic.controller;

import com.krabs.krabmusic.entity.Song;
import com.krabs.krabmusic.error.SongNotFoundException;
import com.krabs.krabmusic.service.SongService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SongController {

    @Autowired
    private SongService songService;

    private final Logger LOGGER = LoggerFactory.getLogger(SongController.class);

    @PostMapping("/songs")
    public Song saveSongs(@Valid @RequestBody Song song){
        //kad ir koki JSON gausim, ji turi convertinti i Song object (del @RequestBody)
        //SongService service = new SongServiceImpl(); cia jeigu manually
        //
        LOGGER.info("Inside saveSongs of SongController");
        return songService.saveSong(song);
    }

    @GetMapping("/songs")
    public List<Song> fetchSongList(){//endpoint
        LOGGER.info("Inside fetchSongList of SongController");
        return songService.fetchSongList();
    }

    @GetMapping("/songs/{id}")
    public Song fetchSongById(@PathVariable("id") Long songId) throws SongNotFoundException {//endpoint
        return songService.fetchSongById(songId);
    }

    @DeleteMapping("/songs/{id}")
    public String deleteSongById(@PathVariable("id") Long songId){//endpoint
        songService.deleteSongById(songId);
        return "Song ID no. "+ songId +" deleted Successfully";
    }

    @PutMapping("/songs/{id}")
    public Song updateSong
            (@PathVariable("id") Long songId,@RequestBody Song song){//endpoint

        return songService.updateSong(songId,song);
    }

    @GetMapping("/songs/name/{name}")
    public Song fetchSongByName(@PathVariable("name") String songName){//endpoint
        return songService.fetchSongByName(songName);
    }
}
