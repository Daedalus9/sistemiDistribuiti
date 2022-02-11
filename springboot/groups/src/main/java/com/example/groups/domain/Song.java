package com.example.groups.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ManyToOne
    private Band band;

    @NotBlank
    private String name;
    private String album;
    private int year;

    public Song() {
    }

    public Song(Band band, String name, String album, int year) {
        this.band = band;
        this.name = name;
        this.album = album;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Band getBand() {
        return this.band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getalbum() {
        return this.album;
    }

    public void setalbum(String album) {
        this.album = album;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", band='" + getBand() + "'" +
            ", name='" + getName() + "'" +
            ", album='" + getalbum() + "'" +
            ", year='" + getYear() + "'" +
            "}";
    }
}