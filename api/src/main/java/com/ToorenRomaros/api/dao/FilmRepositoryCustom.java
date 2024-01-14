package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.film.FilmEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface FilmRepositoryCustom {
    Map<String, Object> findDinamicQuery(String streamSiteId, List<UUID> genres, String suitableFor, String filmType, String atTheaters, String commingSoon, String atStreaming, String orderBy, String userRating, String superRating, int page, int size);
}
