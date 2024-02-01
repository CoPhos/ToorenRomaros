package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.FilmDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface FilmService {
     FilmDto createFilm(FilmDto filmDto);
     FilmDto getFilmById(UUID id);
     List<FilmDto>  getAllFilmsBySagaId(UUID id);
     FilmDto updateFilm(UUID id, FilmDto filmDto);
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
                                               int page,
                                               int size);
}
