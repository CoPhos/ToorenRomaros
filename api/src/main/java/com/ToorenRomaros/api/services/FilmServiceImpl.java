package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.MovieRequestDto;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.MovieRepository;
import com.ToorenRomaros.api.repositories.film.SagaRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class FilmServiceImpl implements FilmService {
    private final MovieRepository movieRepository;
    private final SagaRepository sagaRepository;
    private final ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(FilmServiceImpl.class);

    public FilmServiceImpl(MovieRepository movieRepository, SagaRepository sagaRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.sagaRepository = sagaRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public MovieDto createFilm(MovieRequestDto movieRequestDto) {
        Movie movie = modelMapper.map(movieRequestDto, Movie.class);
        if (movieRequestDto.getPrequel() != null) {
            UUID prequelId = UUID.fromString(movieRequestDto.getPrequel());
            Movie prequel = movieRepository.findById(prequelId)
                    .orElseThrow(() -> new ResourceNotFoundException("Prequel not found"));
            movie.setPrequel(prequel);
        }
        if (movieRequestDto.getSequel() != null) {
            UUID sequelId = UUID.fromString(movieRequestDto.getSequel());
            Movie sequel = movieRepository.findById(sequelId)
                    .orElseThrow(() -> new ResourceNotFoundException("Sequel not found"));
            movie.setSequel(sequel);
        }
        if (movie.getSaga() == null) {
            movie.setSaga(new ArrayList<>());
        }
        movieRepository.save(movie);

        if (movieRequestDto.getSagaName() != null) {
            SagaEntity saga = new SagaEntity(movieRequestDto.getSagaName(), movie);
            movie.getSaga().add(saga);
            sagaRepository.save(saga);
        }

        Movie savedMovie = movieRepository.save(movie);
        return modelMapper.map(savedMovie, MovieDto.class);
    }
}

