package com.example.groups.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.groups.domain.Song;
import com.example.groups.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SongController {

    @Autowired
    private SongService service;

    @GetMapping("/song")
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> entityList = service.getAllSongs();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<Song> getSong(@PathVariable long id) {
        Optional<Song> entity = service.getSong(id);
        if(entity.isPresent())
            return ResponseEntity.ok(entity.get());
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/song/songName/{name}")
    public ResponseEntity<List<Song>> getSongByName(@PathVariable String name) {
        List<Song> entityList = service.getSongByName(name);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/songNameContaining/{name}")
    public ResponseEntity<List<Song>> getSongByNameContaining(@PathVariable String name) {
        List<Song> entityList = service.getSongByNameContaining(name);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/songNameStartingWith/{name}")
    public ResponseEntity<List<Song>> getBySongNameStartingWith(@PathVariable String name) {
        List<Song> entityList = service.getSongByNameStartingWith(name);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/songNameEndingWith/{name}")
    public ResponseEntity<List<Song>> getBySongNameEndingWith(@PathVariable String name) {
        List<Song> entityList = service.getSongByNameEndingWith(name);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/songAlbum/{name}")
    public ResponseEntity<List<Song>> getSongsByAlbum(@PathVariable String name) {
        List<Song> entityList = service.getSongsByAlbum(name);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/songAlbumStartingWith/{name}")
    public ResponseEntity<List<Song>> getSongsByAlbumStartingWith(@PathVariable String name) {
        List<Song> entityList = service.getSongByNameStartingWith(name);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/songAlbumContaining/{name}")
    public ResponseEntity<List<Song>> getSongsByAlbumContaining(@PathVariable String name) {
        List<Song> entityList = service.getSongByAlbumContaining(name);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/songYear/{year}")
    public ResponseEntity<List<Song>> getSongByYear(@PathVariable int year) {
        List<Song> entityList = service.getSongByYear(year);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/songYearLessThan/{year}")
    public ResponseEntity<List<Song>> getSongByYearLessThan(@PathVariable int year) {
        List<Song> entityList = service.getSongByYearLessThan(year);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/songYearLessThanEqual/{year}")
    public ResponseEntity<List<Song>> getSongByYearLessThanEqual(@PathVariable int year) {
        List<Song> entityList = service.getSongByYearLessThanEqual(year);
        return ResponseEntity.ok(entityList);
    }
    
    @GetMapping("/song/songYearGreaterThan/{year}")
    public ResponseEntity<List<Song>> getSongByYearGreaterThan(@PathVariable int year) {
        List<Song> entityList = service.getSongByYearGreaterThan(year);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/songYearGreaterThanEqual/{year}")
    public ResponseEntity<List<Song>> getSongByYearGreaterThanEqual(@PathVariable int year) {
        List<Song> entityList = service.getSongByYearGreaterThanEqual(year);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/song/songYearBetween/{startYear}/{endYear}")
    public ResponseEntity<List<Song>> getSongByYearBetween(@PathVariable int startYear, @PathVariable int endYear) {
        List<Song> entityList = service.getSongByYearBetween(startYear, endYear);
        return ResponseEntity.ok(entityList);
    }

    @PostMapping("/song")
    public ResponseEntity<Song> addSong(@Valid @RequestBody Song e) throws URISyntaxException {
        if (e.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Song entity = service.addSong(e);
        return ResponseEntity.created(new URI("/api/song" + entity.getId())).body(entity);
    }

    @PutMapping("/song")
    public ResponseEntity<Song> updateSong(@Valid @RequestBody Song e) {
        if (e.getId() == null)
            return ResponseEntity.notFound().build();
        Song entity = service.updateSong(e);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/song/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable long id) {
        if (service.getSong(id).isEmpty())
            return ResponseEntity.notFound().build();

        service.deleteSong(id);
        return ResponseEntity.ok().build();
    }
}
