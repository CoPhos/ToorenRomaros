package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.SerieDto;

import java.util.UUID;

public interface FilmService {
     FilmDto createFilm(FilmDto filmDto);
     FilmDto findFilmById(UUID id);
     FilmDto updateFilm(UUID id, FilmDto filmDto);
}
