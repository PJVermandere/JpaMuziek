package com.example.jpamuziek.repositories;

import com.example.jpamuziek.domain.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@Import(JpaAlbumRepository.class)
class JpaAlbumRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final JpaAlbumRepository repository;
    private static final String ALBUMS = "albums";

    JpaAlbumRepositoryTest(JpaAlbumRepository repository) {
        this.repository = repository;
    }

    @Test
    void findAll() {
        assertThat(repository.findAll())
                .hasSize(countRowsInTable(ALBUMS));
    }
}