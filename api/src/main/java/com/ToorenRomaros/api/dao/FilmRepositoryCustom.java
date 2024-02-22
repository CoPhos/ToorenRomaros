package com.ToorenRomaros.api.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface FilmRepositoryCustom {
    Map<String, Object> findByDinamicQuery(List<String> streamSites,
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
                                           int size) throws SQLException;
}
