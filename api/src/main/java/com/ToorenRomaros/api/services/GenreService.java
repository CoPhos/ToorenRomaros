package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.genre.GenreDto;

import java.util.UUID;

public interface GenreService {
    GenreDto createGenre(GenreDto genreDto);
    GenreDto getGenre(UUID id);
    GenreDto updateGenre(UUID id, GenreDto genreDto);
    void deleteGenre (UUID id);
}
