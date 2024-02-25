package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.CreateFilmDto;
import com.ToorenRomaros.api.dto.film.GetDynamicQyeryFilmDto;
import com.ToorenRomaros.api.dto.film.GetFilmDto;
import com.ToorenRomaros.api.dto.film.UpdateFilmDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.film.SagaRepository;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import com.ToorenRomaros.api.utils.FilmMapper;
import com.ToorenRomaros.api.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final SagaRepository sagaRepository;
    private final FilmMapper filmMapper;
    private final ImageRepostiroy imageRepostiroy;
    public FilmServiceImpl(FilmRepository filmRepository, SagaRepository sagaRepository, FilmMapper filmMapper, ImageRepostiroy imageRepostiroy) {
        this.filmRepository = filmRepository;
        this.sagaRepository = sagaRepository;
        this.filmMapper = filmMapper;
        this.imageRepostiroy = imageRepostiroy;
    }
    @Override
    public GetFilmDto createFilm(CreateFilmDto createFilmDto) {
        FilmEntity newMovie = filmMapper.mapCreateFilmDtoToFilmEntity(createFilmDto);
        if (createFilmDto.getSagaId() != null) {
            SagaEntity sagaEntity = sagaRepository.findById(UUID.fromString(createFilmDto.getSagaId())).orElseThrow(() -> new ResourceNotFoundException("Saga not found."));
            newMovie.setSaga(sagaEntity);
        }
        FilmEntity savedMovie = filmRepository.save(newMovie);
        return filmMapper.mapFilmEntityToGetFilmDto(savedMovie);
    }
    @Override
    public Map<String, Object> getFilmByDynamicQuery(List<String> streamSites,
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
                                                     int size) throws SQLException {
        Map<String, Object> result = filmRepository.findByDinamicQuery(streamSites, genres, suitableFor,
                filmType, atTheaters, atStreaming, commingSoonStreaming, commingSoonTheaters, orderBy, userRating, superRating,searchQuery, page, size);
        List<FilmEntity> filmEntities = (List<FilmEntity>) result.get("queryResult");
        result.replace("queryResult", filmEntities.stream().map(filmEntity -> {
            GetDynamicQyeryFilmDto filmDto = filmMapper.mapToGetDynamicQueryFilmDto(filmEntity);
            List<ImageEntity> imageEntities = imageRepostiroy.findAllImageByImageType("FILM_MAIN", filmEntity.getId().toString());
            if (!imageEntities.isEmpty()) {
                filmDto.setMainImageId(imageEntities.get(0).getId().toString());
            }
            return filmDto;
        }).collect(Collectors.toList()));
        return result;
    }
    @Transactional
    @Override
    public GetFilmDto getFilmById(UUID id) {
        FilmEntity film = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Film not found."));
        filmRepository.incrementViewCountByFilmId(id.toString());
        GetFilmDto createFilmDto = filmMapper.mapFilmEntityToGetFilmDto(film);
        List<ImageEntity> imageEntities = imageRepostiroy.findAllImageByImageType("FILM_MAIN", id.toString());
        if (!imageEntities.isEmpty()) {
            createFilmDto.setMainImageId(imageEntities.get(0).getId().toString());
        }
        return createFilmDto;
    }
    @Override
    public List<GetFilmDto> getAllFilmsBySagaId(UUID id) {
        List<FilmEntity> filmEntities = filmRepository.findBySagaId(id.toString());
        return filmEntities.stream().map(filmMapper::mapFilmEntityToGetFilmDto).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public GetFilmDto updateFilm(UUID id, UpdateFilmDto updateFilmDto) {
        FilmEntity newFilm = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Film not found."));
        FilmEntity film = filmMapper.mapUpdateFilmDtoToFilmEntity(updateFilmDto);
        film.setSaga(null);
        BeanUtils.copyProperties(film, newFilm, Utils.getNullPropertyNames(film));
        if (updateFilmDto.getSagaId() != null) {
            SagaEntity sagaEntity = sagaRepository.findById(UUID.fromString(updateFilmDto.getSagaId())).orElseThrow(() -> new ResourceNotFoundException("Saga not found."));
            newFilm.setSaga(sagaEntity);
        }
        FilmEntity savedFilm = filmRepository.save(newFilm);
        return filmMapper.mapFilmEntityToGetFilmDto(savedFilm);
    }
    @Override
    public void deleteFilm(UUID id) {
        filmRepository.findById(id)
                .ifPresentOrElse(filmRepository::delete, () -> {
                    throw new ResourceNotFoundException("Film not found.");
                });
    }
}

