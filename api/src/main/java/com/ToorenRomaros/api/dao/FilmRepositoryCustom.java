package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.genre.GenreFilmEntity;

import java.util.List;
import java.util.UUID;

public interface FilmRepositoryCustom {
    List<FilmEntity> findFilmByNameAndDuration(String streamSiteId, List<UUID> genres, String suitableFor, String filmType, boolean atTheaters, boolean commingSoon, boolean atStreaming);
}
