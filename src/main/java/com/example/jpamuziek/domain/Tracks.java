package com.example.jpamuziek.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
@Table(name = "tracks")
@Access(AccessType.FIELD)
public class Tracks {
    private String naam;
    private LocalTime tijd;

    public Tracks(String naam, LocalTime tijd) {
        this.naam = naam;
        this.tijd = tijd;
    }

    protected Tracks() {

    }

    public String getNaam() {
        return naam;
    }

    public LocalTime getTijd() {
        return tijd;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Tracks tracks
                && Objects.equals(naam, tracks.naam)
                && Objects.equals(tijd, tracks.tijd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, tijd);
    }
}
