package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.genre.CreateGenreFilmDto;
import com.ToorenRomaros.api.dto.genre.GetGenreFilmDto;

import java.util.List;
import java.util.UUID;

public interface GenreFilmService {
    GetGenreFilmDto createGenreFilm(CreateGenreFilmDto createGenreFilmDto);
    List<GetGenreFilmDto> getGenreFilm(UUID id);
    GetGenreFilmDto updateGenreFilm(UUID id, CreateGenreFilmDto createGenreFilmDto);
    void deleteGenreFilm(UUID id);
}
