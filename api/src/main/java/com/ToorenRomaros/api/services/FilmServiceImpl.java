package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.film.SagaRepository;
import com.ToorenRomaros.api.utils.FilmMapper;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final ModelMapper modelMapper;
    private final FilmMapper filmMapper;
    private static final Logger log = LoggerFactory.getLogger(FilmServiceImpl.class);

    public FilmServiceImpl(FilmRepository filmRepository, ModelMapper modelMapper, FilmMapper filmMapper) {
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
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
        FilmEntity savedMovie = filmRepository.save(newMovie);
        return filmMapper.mapToFilmDto(savedMovie);
    }
    @Override
    public FilmDto findFilmById(UUID id) {
        FilmEntity film = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return filmMapper.mapToFilmDto(film);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public FilmDto updateFilm(UUID id, FilmDto filmDto) {
        FilmEntity newFilm = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        FilmEntity film = filmMapper.mapToFilmEntity(filmDto);

        film.setSequel(null);
        film.setPrequel(null);

        BeanUtils.copyProperties(film, newFilm, Utils.getNullPropertyNames(film));

        if (filmDto.getSequel() != null) {
            newFilm.setSequel(addSequel(filmDto));
        }
        if (filmDto.getPrequel() != null) {
            newFilm.setPrequel(addPrequel(filmDto));
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

