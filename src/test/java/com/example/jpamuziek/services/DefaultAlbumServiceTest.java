package com.example.jpamuziek.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(DefaultAlbumService.class)
@ComponentScan(value = "com/example/jpamuziek/repositories", resourcePattern = "JpaAlbumRepository.class")
class DefaultAlbumServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final DefaultAlbumService service;
    private static final String ALBUMS_TABLE = "albums";

    DefaultAlbumServiceTest(DefaultAlbumService service) {
        this.service = service;
    }

    @Test
    void getAllAlbums() {
        assertThat(service.getAllAlbums()).hasSize(countRowsInTable(ALBUMS_TABLE));
    }
}