package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.genre.GenreFilmDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;

import java.util.List;
import java.util.UUID;

public interface GenreFilmService {
    GenreFilmDto createGenreFilm(GenreFilmDto genreFilmDto);
    List<GenreFilmDto> getGenreFilm(UUID id);
    GenreFilmDto updateGenreFilm(UUID id, GenreFilmDto genreFilmDto);
    void deleteGenreFilm(UUID id);
}
