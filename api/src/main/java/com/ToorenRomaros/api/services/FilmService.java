package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.MovieAddRequestDto;
import com.ToorenRomaros.api.dto.film.SerieAddRequestDto;
import com.ToorenRomaros.api.dto.film.SerieDto;

import java.util.UUID;

public interface FilmService {
     MovieDto createMovie(MovieAddRequestDto movieAddRequestDto);
     SerieDto createSerie(SerieAddRequestDto serieAddRequestDto);
     MovieDto findMovieById(UUID id);
     SerieDto findSerieById(UUID id);
     MovieDto updateMovie(UUID id, MovieAddRequestDto movieAddRequestDto);
     SerieDto updateSerie(UUID id, SerieAddRequestDto serieAddRequestDto);

}
