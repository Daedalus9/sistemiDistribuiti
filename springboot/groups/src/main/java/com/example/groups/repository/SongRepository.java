package com.example.groups.repository;

import java.util.List;

import com.example.groups.domain.Song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>{
    List<Song> findByBandName(String name);
    List<Song> findByName(String name);
    List<Song> findByNameStartingWith(String name);
    List<Song> findByAlbum(String name);
    List<Song> findByAlbumContaining(String name); 
    List<Song> findByYear(int year);
    List<Song> findByYearLessThan(int year);
    List<Song> findByYearLessThanEqual(int year);
    List<Song> findByYearGreaterThan(int year);
    List<Song> findByYearGreaterThanEqual(int year);
    List<Song> findByYearBetween(int startYear, int endYear);
}
