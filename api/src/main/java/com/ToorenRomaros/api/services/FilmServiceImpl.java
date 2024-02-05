package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.film.GetDynamicQyeryFilmDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.film.SagaRepository;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import com.ToorenRomaros.api.utils.FilmMapper;
import com.ToorenRomaros.api.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final SagaRepository sagaRepository;
    private final FilmMapper filmMapper;
    private final ImageRepostiroy imageRepostiroy;
    private static final Logger log = LoggerFactory.getLogger(FilmServiceImpl.class);

    public FilmServiceImpl(FilmRepository filmRepository, SagaRepository sagaRepository, FilmMapper filmMapper, ImageRepostiroy imageRepostiroy) {
        this.filmRepository = filmRepository;
        this.sagaRepository = sagaRepository;
        this.filmMapper = filmMapper;
        this.imageRepostiroy = imageRepostiroy;
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public FilmDto createFilm(FilmDto filmDto) {
        FilmEntity newMovie = filmMapper.mapToFilmEntity(filmDto);
        if (filmDto.getSagaId() != null) {
            SagaEntity sagaEntity = sagaRepository.findById(UUID.fromString(filmDto.getSagaId())).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
            newMovie.setSaga(sagaEntity);
        }
        FilmEntity savedMovie = filmRepository.save(newMovie);
        return filmMapper.mapToFilmDto(savedMovie);
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
                                                     int page,
                                                     int size) {
        Map<String, Object> result = filmRepository.findDinamicQuery(streamSites, genres, suitableFor,
                filmType, atTheaters, atStreaming, commingSoonStreaming, commingSoonTheaters, orderBy, userRating, superRating, page, size);
        List<FilmEntity> filmEntities = (List<FilmEntity>) result.get("queryResult");
        if (filmEntities == null) {
            throw new ResourceNotFoundException("Resource not found");
        }
        result.replace("queryResult", filmEntities.stream().map(filmEntity -> {
            List<ImageEntity> imageEntities = imageRepostiroy.findAllImageByImageType("FILM_MAIN", filmEntity.getId().toString());
            log.info(imageEntities.get(0).getId().toString());
            if (!imageEntities.isEmpty()) {
                GetDynamicQyeryFilmDto filmDto = filmMapper.mapToGetDynamicQueryFilmDto(filmEntity);
                filmDto.setMainImageId(imageEntities.get(0).getId().toString());
                return filmDto;
            } else {
                return filmMapper.mapToGetDynamicQueryFilmDto(filmEntity);
            }
        }).collect(Collectors.toList()));
        return result;
    }

    @Override
    @Transactional
    public FilmDto getFilmById(UUID id) {
        filmRepository.incrementViewCount(id.toString());
        FilmEntity film = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        FilmDto filmDto = filmMapper.mapToFilmDto(film);
        List<ImageEntity> imageEntities = imageRepostiroy.findAllImageByImageType("FILM_MAIN", id.toString());
        if (!imageEntities.isEmpty()) {
            filmDto.setMainImageId(imageEntities.get(0).getId().toString());
            return filmDto;
        } else {
            return filmDto;
        }
    }

    @Override
    public List<FilmDto> getAllFilmsBySagaId(UUID id) {
        List<FilmEntity> filmEntities = filmRepository.getAllFilmbySagaId(id.toString());
        if (filmEntities == null) {
            throw new ResourceNotFoundException("Resource not found");
        }
        return filmEntities.stream().map(filmMapper::mapToFilmDto).collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public FilmDto updateFilm(UUID id, FilmDto filmDto) {
        FilmEntity newFilm = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        FilmEntity film = filmMapper.mapToFilmEntity(filmDto);

        film.setSaga(null);

        BeanUtils.copyProperties(film, newFilm, Utils.getNullPropertyNames(film));

        if (filmDto.getSagaId() != null) {
            SagaEntity sagaEntity = sagaRepository.findById(UUID.fromString(filmDto.getSagaId())).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
            newFilm.setSaga(sagaEntity);
        }
        FilmEntity savedFilm = filmRepository.save(newFilm);
        return filmMapper.mapToFilmDto(savedFilm);
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public void deleteFilm(UUID id) {
        filmRepository.deleteById(id);
    }
}

