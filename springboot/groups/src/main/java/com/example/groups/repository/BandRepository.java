package com.example.groups.repository;

import java.util.List;
import java.util.Optional;

import com.example.groups.domain.Band;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends JpaRepository<Band, Long>{
    Optional<Band> findByName(String name);
    List<Band> findByNameLike(String likePattern);
    List<Band> findByNameContaining(String name);
    List<Band> findByNameStartingWith(String name);
    List<Band> findByNameEndingWith(String name);
    List<Band> findByNameIsNot(String name);
}