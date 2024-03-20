package com.krabs.krabmusic.repository;

import com.krabs.krabmusic.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {
//sitam nekursim CRUD implementationo, o jis extendins jpa repository{

    // CRUD jau yra JPA,
    // bet aš noriu metodo kuris gettina entity by name, JPA tokio neturi, todėl susikuriu pats.
    // ##NOTE: jie returnina tik 1 entity, breaks kai returnina daugiau nei 1##
    // galima naudoti @Query(value = "cia rasosi query", nativeQuery = true) using native SQL query
    public Song findBySongName (String songName); //Spring Data JPA automatically generates query to retrieve data
    public Song findBySongNameIgnoreCase(String songName);
    public List<Song> findAllBySongNameIgnoreCase(String songName);

}
