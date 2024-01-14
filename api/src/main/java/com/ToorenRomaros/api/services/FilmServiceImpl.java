package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.film.SagaRepository;
import com.ToorenRomaros.api.utils.FilmMapper;
import com.ToorenRomaros.api.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final SagaRepository sagaRepository;
    private final FilmMapper filmMapper;
    private static final Logger log = LoggerFactory.getLogger(FilmServiceImpl.class);

    public FilmServiceImpl(FilmRepository filmRepository, SagaRepository sagaRepository, FilmMapper filmMapper) {
        this.filmRepository = filmRepository;
        this.sagaRepository = sagaRepository;
        this.filmMapper = filmMapper;
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public FilmDto createFilm(FilmDto filmDto) {
        FilmEntity newMovie = filmMapper.mapToFilmEntity(filmDto);
        if (filmDto.getSequel() != null) {
            newMovie.setSequel(addSequel(filmDto));
        }
        if (filmDto.getPrequel() != null) {
            newMovie.setPrequel(addPrequel(filmDto));
        }
        if (filmDto.getSagaId() != null) {
            SagaEntity sagaEntity = sagaRepository.findById(UUID.fromString(filmDto.getSagaId())).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
            newMovie.setSaga(sagaEntity);
        }
        FilmEntity savedMovie = filmRepository.save(newMovie);
        return filmMapper.mapToFilmDto(savedMovie);
    }
    @Override
    public Map<String, Object> getFilmByDynamicQuery(String streamSiteId, List<UUID> genres, String suitableFor, String filmType, String atTheaters, String coomingSoon, String atStreaming, String orderBy, String userRating, String superRating, int page, int size) {
        Map<String, Object> result = filmRepository.findDinamicQuery(streamSiteId, genres, suitableFor,
                filmType, atTheaters, coomingSoon, atStreaming, orderBy, userRating, superRating, page, size);
        List<FilmEntity> filmEntities = (List<FilmEntity>) result.get("queryResult");
        if (filmEntities == null) {
            throw new ResourceNotFoundException("Resource not found");
        }
            result.replace("queryResult", filmEntities.stream().map(filmMapper::mapToGetDynamicQueryFilmDto).collect(Collectors.toList()));
            return result;
    }
    @Override
    public FilmDto getFilmById(UUID id) {
        FilmEntity film = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return filmMapper.mapToFilmDto(film);
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

        film.setSequel(null);
        film.setPrequel(null);
        film.setSaga(null);

        BeanUtils.copyProperties(film, newFilm, Utils.getNullPropertyNames(film));

        if (filmDto.getSequel() != null) {
            newFilm.setSequel(addSequel(filmDto));
        }
        if (filmDto.getPrequel() != null) {
            newFilm.setPrequel(addPrequel(filmDto));
        }
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
    private FilmEntity addSequel(FilmDto filmDto) {
        String newSequelId = filmDto.getSequel();
        return filmRepository.findById(UUID.fromString(newSequelId)).orElseThrow(() -> new ResourceNotFoundException(newSequelId + " not found"));
    }
    private FilmEntity addPrequel(FilmDto filmDto) {
        String newPrequelId = filmDto.getPrequel();
        return filmRepository.findById(UUID.fromString(newPrequelId)).orElseThrow(() -> new ResourceNotFoundException(newPrequelId + " not found"));
    }
}

