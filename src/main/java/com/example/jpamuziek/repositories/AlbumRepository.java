package com.example.jpamuziek.repositories;

import com.example.jpamuziek.domain.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository {
    List<Album> findAll();
    Optional<Album> findById(long id);
}
