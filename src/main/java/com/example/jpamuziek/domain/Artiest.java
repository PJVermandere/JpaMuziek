package com.example.jpamuziek.domain;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name = "artiesten")
public class Artiest {
    @Id private long id;
    private String naam;


    protected Artiest() {
    }

    public Artiest(long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
