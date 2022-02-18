package com.example.groups.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.groups.domain.Song;
import com.example.groups.repository.SongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    @Autowired
    private SongRepository repository;

    public Song addSong(Song e) {
        return repository.save(e);
    }

    public Optional<Song> getSong(Long id) {
        return repository.findById(id);
    }

    public List<Song> getSongByName(String name) {
        return repository.findByName(name);
    }

    public List<Song> getSongByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    public List<Song> getSongByNameStartingWith(String name) {
        return repository.findByNameStartingWith(name);
    }

    public List<Song> getSongByNameEndingWith(String name) {
        return repository.findByNameEndingWith(name);
    }

    public List<Song> getSongsByAlbum(String name) {
        return repository.findByAlbum(name);
    }

    public List<Song> getSongByAlbumContaining(String name) {
        return repository.findByAlbumContaining(name);
    }

    public List<Song> getSongsByAlbumStartingWith(String name) {
        return repository.findByAlbumStartingWith(name);
    }

    public List<Song> getSongByYear(int year) {
        return repository.findByYear(year);
    }

    public List<Song> getSongByYearLessThan(int year) {
        return repository.findByYearLessThan(year);
    }

    public List<Song> getSongByYearLessThanEqual(int year) {
        return repository.findByYearLessThanEqual(year);
    }

    public List<Song> getSongByYearGreaterThan(int year) {
        return repository.findByYearGreaterThan(year);
    }

    public List<Song> getSongByYearGreaterThanEqual(int year) {
        return repository.findByYearGreaterThanEqual(year);
    }

    public List<Song> getSongByYearBetween(int startYear, int endYear) {
        return repository.findByYearBetween(startYear, endYear);
    }

    public List<Song> getSongByBandName(String name) {
        return repository.findByBandName(name);
    }

    public List<Song> getAllSongs() {
        List<Song> output = new ArrayList<Song>();
        repository.findAll().forEach(output::add);
        return output;
    }

    public Song updateSong(Song e) {
        return repository.save(e);
    }

    public void deleteSong(Song e) {
        repository.delete(e);
}

    public void deleteSong(Long id) {
        repository.deleteById(id);
    }
}
