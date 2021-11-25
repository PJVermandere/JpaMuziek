package com.example.jpamuziek.services;

import com.example.jpamuziek.domain.Album;
import com.example.jpamuziek.exceptions.AlbumNietGevondenException;
import com.example.jpamuziek.repositories.AlbumRepository;
import com.example.jpamuziek.repositories.JpaAlbumRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaultAlbumService implements AlbumService {
    private final AlbumRepository repository;

    public DefaultAlbumService(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Album> getAllAlbums() {
        return repository.findAll();
    }

    @Override
    public Album findAlbumById(long id) {
        return repository.findById(id).orElseThrow(AlbumNietGevondenException::new);
    }

    @Override
    public void wijzigScore(long id, long score) {
        repository.findById(id).orElseThrow(AlbumNietGevondenException::new).wijzigScore(score);
    }
}
