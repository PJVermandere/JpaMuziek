package com.example.jpamuziek.repositories;

import com.example.jpamuziek.domain.Album;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Album> findAlbumsByYear(int jaar) {
        return manager.createNamedQuery("Album.findAlbumsByYear")
                .setParameter("jaar", jaar)
                .getResultList();
    }

    @Override
    public List<Album> findAlbumsByArtistId(long artiestId) {
        return manager.createNamedQuery("Album.findAlbumsByArtiestId")
                .setParameter("artiestId", artiestId)
                .getResultList();
    }

    @Override
    public Optional<Album> findById(long id) {
        return Optional.ofNullable(manager.find(Album.class, id));
    }
}
