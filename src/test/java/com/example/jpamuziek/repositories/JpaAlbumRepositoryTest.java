package com.example.jpamuziek.repositories;

import com.example.jpamuziek.domain.Album;
import com.example.jpamuziek.domain.Artiest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@Import(JpaAlbumRepository.class)
class JpaAlbumRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final JpaAlbumRepository repository;
    private final EntityManager manager;
    private static final String ALBUMS = "albums";

    JpaAlbumRepositoryTest(JpaAlbumRepository repository, EntityManager manager) {
        this.repository = repository;
        this.manager = manager;
    }

    @Test
    void findAll() {
        var albums = repository.findAll();
        manager.clear();
        assertThat(albums)
                .hasSize(countRowsInTable(ALBUMS));
        assertThat(albums)
                .extracting(Album::getArtiest)
                .extracting(Artiest::getNaam);

    }
}