package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;

import java.util.List;

public interface FilmRepositoryCustom {
    List<FilmEntity> findFilmByNameAndDuration(String name, String duration);
}
