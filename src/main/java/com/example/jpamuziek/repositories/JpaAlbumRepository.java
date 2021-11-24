package com.example.jpamuziek.repositories;

import com.example.jpamuziek.domain.Album;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaAlbumRepository implements AlbumRepository {
    private final EntityManager manager;

    public JpaAlbumRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Album> findAll() {
        return manager.createNamedQuery("Album.findAll")
                .getResultList();
    }
}
