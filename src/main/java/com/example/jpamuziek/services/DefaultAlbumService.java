package com.example.jpamuziek.services;

import com.example.jpamuziek.domain.Album;
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
}
