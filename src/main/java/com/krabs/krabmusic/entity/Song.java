package com.krabs.krabmusic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.Duration;
import java.time.LocalDate;


@Entity
@Data // galima atsikrai naudoti @Getter @setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder // Builder design pattern
public class Song {

    @Id// marks primary key
    @GeneratedValue(strategy= GenerationType.AUTO)// auto increment ID
    private Long songId;
    @NotBlank(message = "Please Add Song Name")
    @Length(max = 30, min = 5)
    //@Size(min = 1, max = 5) // more for playlists and albums (Array/List size)
    private String songName;
    private int songLength;
    private String songDescription;
    @Past
    private LocalDate songCreatedAt;

    //Naudojant Lombok, nereikes konstruktoriu, getters ir setters.
    /*
    public Song() {
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Duration getSongLength() {
        return songLength;
    }

    public void setSongLength(Duration songLength) {
        this.songLength = songLength;
    }

    public String getSongDescription() {
        return songDescription;
    }

    public void setSongDescription(String songDescription) {
        this.songDescription = songDescription;
    }

    public LocalDate getSongCreatedAt() {
        return songCreatedAt;
    }

    public void setSongCreatedAt(LocalDate songCreatedAt) {
        this.songCreatedAt = songCreatedAt;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", songLength=" + songLength +
                ", songDescription='" + songDescription + '\'' +
                ", created_at=" + songCreatedAt +
                '}';
    }
    */
}
