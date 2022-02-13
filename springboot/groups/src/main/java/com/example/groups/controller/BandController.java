package com.example.groups.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.groups.domain.Band;
import com.example.groups.domain.Song;
import com.example.groups.service.BandService;
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
public class BandController {

    @Autowired
    private BandService service;

    @Autowired
    private SongService songService;

    @GetMapping("/band")
    public ResponseEntity<List<Band>> getAllBands() {
        List<Band> entityList = service.getAllBands();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/band/{id}")
    public ResponseEntity<Band> getBand(@PathVariable long id) {
        Optional<Band> entity = service.getBand(id);
        if(entity.isPresent())
            return ResponseEntity.ok(entity.get());
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/band/bandName/{name}")
    /*public ResponseEntity<Band> getByBandName(@PathVariable String name) {
        Optional<Band> entity = service.getByBandName(name);
        if(entity.isPresent()) return ResponseEntity.ok(entity.get());
        else return ResponseEntity.notFound().build();*/
    public ResponseEntity<List<Band>> getByBandNameContaining(@PathVariable String name){
        List<Band> entityList = service.getByBandNameContaining(name);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/getSongsByBandName/{name}")
    public ResponseEntity<List<Song>> getSongsByBandName(@PathVariable String name) {
        List<Song> entityList = songService.getSongByBandName(name);
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/band/bandNameStartingWith/{name}")
    public ResponseEntity<List<Band>> getByBandNameStartingWith(@PathVariable String name) {
        List<Band> entityList = service.getByBandNameStartingWith(name);
        return ResponseEntity.ok(entityList);
    }


    @PostMapping("/band")
    public ResponseEntity<Band> addBand(@Valid @RequestBody Band e) throws URISyntaxException {
        if (e.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Band entity = service.addBand(e);
        return ResponseEntity.created(new URI("/api/band" + entity.getId())).body(entity);
    }

    @PutMapping("/band")
    public ResponseEntity<Band> updateBand(@Valid @RequestBody Band e) {
        if (e.getId() == null)
            return ResponseEntity.notFound().build();
        Band entity = service.updateBand(e);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/band/{id}")
    public ResponseEntity<Void> deleteBand(@PathVariable long id) {
        if (service.getBand(id).isEmpty())
            return ResponseEntity.notFound().build();

        service.deleteBand(id);
        return ResponseEntity.ok().build();
    }
}
