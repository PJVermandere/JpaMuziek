package com.example.jpamuziek.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table(name = "albums")
@NamedEntityGraph(name = Album.ALBUM_FINDARTIEST, attributeNodes = @NamedAttributeNode("artiest"))
public class Album {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artiestId")
    private Artiest artiest;
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

    @Override
    public boolean equals(Object o) {
        return o instanceof Album album && barcode == album.barcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode);
    }
}
