package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.film.FilmEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface FilmRepositoryCustom {
    Map<String, Object> findDinamicQuery(String streamSiteId, List<UUID> genres, String suitableFor, String filmType, boolean atTheaters, boolean commingSoon, boolean atStreaming, String orderBy, String userRating, String superRating, int page, int size);
}
