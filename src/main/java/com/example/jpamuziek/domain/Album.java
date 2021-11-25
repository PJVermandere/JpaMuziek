package com.example.jpamuziek.domain;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity @Table(name = "albums")
@NamedEntityGraph(name = Album.ALBUM_FINDARTIEST, attributeNodes = @NamedAttributeNode("artiest"))
public class Album {
    @Id
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artiestId")
    private Artiest artiest;
    @ElementCollection
    @CollectionTable(name = "tracks", joinColumns = @JoinColumn(name = "albumId"))
    @OrderBy("naam")
    private Set<Tracks> tracks;
    private String naam;
    private int jaar, score;
    private long barcode;
    public static final String ALBUM_FINDARTIEST = "Album.findArtiest";


    public Album() {
    }

    public Album( Artiest artiest, String naam, int jaar, int score, long barcode) {
        this.artiest = artiest;
        this.naam = naam;
        this.jaar = jaar;
        this.score = score;
        this.barcode = barcode;
        this.tracks = new LinkedHashSet<>();
    }

    public long getId() {
        return id;
    }

    public Artiest getArtiest() {
        return artiest;
    }

    public String getNaam() {
        return naam;
    }

    public int getJaar() {
        return jaar;
    }

    public int getScore() {
        return score;
    }

    public long getBarcode() {
        return barcode;

    }

    public LocalTime getTotaalTijd() {
        LocalTime som = LocalTime.MIN;
        for(var track: tracks){
            var tijd = track.getTijd();
            som = som.plusHours(tijd.getHour()).plusMinutes(tijd.getMinute()).plusSeconds(tijd.getSecond());
        };
        return som;
    }

    public Set<Tracks> getTracks() {
        return Collections.unmodifiableSet(tracks);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Album album && barcode == album.barcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode);
    }
}
