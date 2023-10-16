package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.FilmDto;

import java.util.List;
import java.util.UUID;

public interface FilmService {
     FilmDto createFilm(FilmDto filmDto);
     FilmDto getFilmById(UUID id);
     List<FilmDto>  getAllFilmsBySagaId(UUID id);
     FilmDto updateFilm(UUID id, FilmDto filmDto);
     void deleteFilm(UUID id);
}
