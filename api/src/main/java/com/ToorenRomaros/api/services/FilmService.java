package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.SerieDto;

import java.util.UUID;

public interface FilmService {
     MovieDto createMovie(MovieDto movieDto);
     SerieDto createSerie(SerieDto serieDto);
     MovieDto findMovieById(UUID id);
     SerieDto findSerieById(UUID id);
     MovieDto updateMovie(UUID id, MovieDto movieDto);
     SerieDto updateSerie(UUID id, SerieDto serieDto);

}
