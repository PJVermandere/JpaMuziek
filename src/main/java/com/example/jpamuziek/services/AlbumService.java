package com.example.jpamuziek.services;

import com.example.jpamuziek.domain.Album;
import com.example.jpamuziek.exceptions.AlbumNietGevondenException;

import java.util.List;

public interface AlbumService {
    List<Album> getAllAlbums();
    Album findAlbumById(long id) throws AlbumNietGevondenException;
    void wijzigScore(long id, long score);
}
