package com.example.groups.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.groups.domain.Band;
import com.example.groups.repository.BandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandService {

    @Autowired
    private BandRepository repository;

    public Band addBand(Band e) {
        return repository.save(e);
    }

    public Optional<Band> getBand(Long id) {
        return repository.findById(id);
    }

    public Optional<Band> getByBandName(String name) {
        return repository.findByName(name);
    }

    public List<Band> getByBandNameLike(String likePattern) {
        return repository.findByNameLike(likePattern);
    }

    public List<Band> getByBandNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    public List<Band> getByBandNameStartingWith(String name) {
        return repository.findByNameStartingWith(name);
    }

    public List<Band> getByBandNameEndingWith(String name) {
        return repository.findByNameEndingWith(name);
    }

    public List<Band> getByBandNameIsNot(String name) {
        return repository.findByNameIsNot(name);
    }

    public List<Band> getAllBands() {
        List<Band> output = new ArrayList<Band>();
        repository.findAll().forEach(output::add);
        return output;
    }


    public Band updateBand(Band e) {
        return repository.save(e);
    }

    public void deleteBand(Band e) {
        repository.delete(e);
}

    public void deleteBand(Long id) {
        repository.deleteById(id);
    }
}