package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.film.FilmEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface FilmRepositoryCustom {
    Map<String, Object> findDinamicQuery(List<String> streamSites,
                                         List<String> genres,
                                         List<String> suitableFor,
                                         String filmType,
                                         String atTheaters,
                                         String atStreaming,
                                         String commingSoonStreaming,
                                         String commingSoonTheaters,
                                         String[] orderBy,
                                         String userRating,
                                         String superRating,
                                         String searchQuery,
                                         int page,
                                         int size);
}
