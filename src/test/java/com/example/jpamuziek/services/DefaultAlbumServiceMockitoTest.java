package com.example.jpamuziek.services;

import com.example.jpamuziek.domain.Album;
import com.example.jpamuziek.domain.Artiest;
import com.example.jpamuziek.repositories.AlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Import(DefaultAlbumService.class)
@ExtendWith(MockitoExtension.class)
class DefaultAlbumServiceMockitoTest {
    private AlbumService service;
    @Mock
    private AlbumRepository repository;
    private Album album, album1;
    @BeforeEach
    void setUp() {
        service = new DefaultAlbumService(repository);
        album = new Album(new Artiest("TestArtiest"), "testAlbum", 1289, 5, 1L );
        album1 = new Album(new Artiest("TestArtiest1"), "testAlbum1", 1289, 5, 1L );
    }

    @Test
    void getAllAlbums() {
        when(repository.findAll()).thenReturn(List.of(album, album1));
        assertThat(service.getAllAlbums()).containsExactly(album, album1);
        verify(repository).findAll();
    }
}