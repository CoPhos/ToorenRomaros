package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.MovieRequestDto;
import com.ToorenRomaros.api.entities.film.Movie;

public interface FilmService {
     MovieDto createFilm(MovieRequestDto movieRequestDto);
}
