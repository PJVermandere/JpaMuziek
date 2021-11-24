package com.example.jpamuziek.repositories;

import com.example.jpamuziek.domain.Album;
import com.example.jpamuziek.domain.Artiest;
import com.example.jpamuziek.domain.Tracks;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;

import java.time.LocalTime;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@Import(JpaAlbumRepository.class)
@Sql("/JpaAlbumRepositoryTest.sql")
class JpaAlbumRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final JpaAlbumRepository repository;
    private final EntityManager manager;
    private static final String ALBUMS = "albums";

    JpaAlbumRepositoryTest(JpaAlbumRepository repository, EntityManager manager) {
        this.repository = repository;
        this.manager = manager;
    }

    long idVanTest(){
        return jdbcTemplate.queryForObject("select id from albums where naam=?", Long.class, "TestAlbum");
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
    @Test
    void findById(){
        assertThat(repository.findById(idVanTest()))
                .hasValueSatisfying(album -> assertThat(album.getTracks().size()).isOne());
    }
}