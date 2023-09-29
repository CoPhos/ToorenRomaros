package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.MovieAddRequestDto;

public interface FilmService {
     MovieDto createFilm(MovieAddRequestDto movieAddRequestDto);
}
