package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.CreateFilmDto;
import com.ToorenRomaros.api.dto.film.UpdateFilmDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface FilmService {
     CreateFilmDto createFilm(CreateFilmDto createFilmDto);
     CreateFilmDto getFilmById(UUID id);
     List<CreateFilmDto>  getAllFilmsBySagaId(UUID id);
     UpdateFilmDto updateFilm(UUID id, UpdateFilmDto updateFilmDto);
     void deleteFilm(UUID id);
     Map<String, Object> getFilmByDynamicQuery(List<String> streamSites,
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
