package com.example.jpamuziek.repositories;

import com.example.jpamuziek.domain.Album;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.jpamuziek.domain.Album.ALBUM_FINDARTIEST;

@Repository
public class JpaAlbumRepository implements AlbumRepository {
    private final EntityManager manager;

    public JpaAlbumRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Album> findAll() {
        return manager.createNamedQuery("Album.findAll")
                .setHint("javax.persistence.loadgraph", manager.createEntityGraph(ALBUM_FINDARTIEST))
                .getResultList();
    }
}
