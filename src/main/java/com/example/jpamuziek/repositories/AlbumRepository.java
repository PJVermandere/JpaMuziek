package com.example.jpamuziek.repositories;

import com.example.jpamuziek.domain.Album;

import java.util.List;

public interface AlbumRepository {
    List<Album> findAll();
}
