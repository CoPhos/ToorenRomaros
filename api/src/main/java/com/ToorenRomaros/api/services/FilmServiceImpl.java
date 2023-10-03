package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.SerieDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.MovieRepository;
import com.ToorenRomaros.api.repositories.film.SagaRepository;
import com.ToorenRomaros.api.repositories.film.SerieRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class FilmServiceImpl implements FilmService {
    private final MovieRepository movieRepository;
    private final SagaRepository sagaRepository;
    private final SerieRepository serieRepository;
    private final ModelMapper modelMapper;
    private static final Logger log = LoggerFactory.getLogger(FilmServiceImpl.class);

    public FilmServiceImpl(MovieRepository movieRepository, SagaRepository sagaRepository, SerieRepository serieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.sagaRepository = sagaRepository;
        this.serieRepository = serieRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        Movie newMovie = modelMapper.map(movieDto, Movie.class);
        movieRepository.save(newMovie);

        if (movieDto.getSagaName() != null) {
            sagaRepository.save(createSaga(movieDto, newMovie));
        }
        if (movieDto.getSequel() != null) {
            newMovie.setSequel(addSequel(movieDto));
        }
        if (movieDto.getPrequel() != null) {
            newMovie.setPrequel(addPrequel(movieDto));
        }

        Movie savedMovie = movieRepository.save(newMovie);
        return modelMapper.map(savedMovie, MovieDto.class);
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public SerieDto createSerie(SerieDto serieDto) {
        Serie newSerie = modelMapper.map(serieDto, Serie.class);
        serieRepository.save(newSerie);

        if (serieDto.getSagaName() != null) {
            sagaRepository.save(createSaga(serieDto, newSerie));
        }
        if (serieDto.getSequel() != null) {
            newSerie.setSequel(addSequel(serieDto));
        }
        if (serieDto.getPrequel() != null) {
            newSerie.setPrequel(addPrequel(serieDto));
        }
        Serie savedSerie = serieRepository.save(newSerie);
        return modelMapper.map(savedSerie, SerieDto.class);
    }

    @Override
    public MovieDto findMovieById(UUID id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        return modelMapper.map(movie, MovieDto.class);
    }

    @Override
    public SerieDto findSerieById(UUID id) {
        Serie serie = serieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tv Serie not found"));
        return modelMapper.map(serie, SerieDto.class);
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public MovieDto updateMovie(UUID id, MovieDto movieDto) {
        Movie newMovie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        Movie movie = modelMapper.map(movieDto, Movie.class);

        movie.setSequel(null);
        movie.setPrequel(null);

        BeanUtils.copyProperties(movie, newMovie, Utils.getNullPropertyNames(movie));
        movieRepository.save(newMovie);

        if (movieDto.getSagaName() != null) {
            sagaRepository.save(createSaga(movieDto, newMovie));
        }
        if (movieDto.getSequel() != null) {
            newMovie.setSequel(addSequel(movieDto));
        }
        if (movieDto.getPrequel() != null) {
            newMovie.setPrequel(addPrequel(movieDto));
        }

        Movie savedMovie = movieRepository.save(newMovie);
        return modelMapper.map(savedMovie, MovieDto.class);
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public SerieDto updateSerie(UUID id, SerieDto serieDto) {
        Serie newSerie = serieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tv Serie not found"));
        Serie serie = modelMapper.map(serieDto, Serie.class);

        serie.setSequel(null);
        serie.setPrequel(null);

        BeanUtils.copyProperties(serie, newSerie, Utils.getNullPropertyNames(serie));
        serieRepository.save(newSerie);

        if (serieDto.getSagaName() != null) {
            sagaRepository.save(createSaga(serieDto, newSerie));
        }
        if (serieDto.getSequel() != null) {
            newSerie.setSequel(addSequel(serieDto));
        }
        if (serieDto.getPrequel() != null) {
            newSerie.setPrequel(addPrequel(serieDto));
        }

        Serie savedSerie = serieRepository.save(newSerie);
        return modelMapper.map(savedSerie, SerieDto.class);
    }

    private FilmEntity addSequel(FilmDto filmDto) {
        String newSequelId = filmDto.getSequel();
        FilmEntity newSequel = serieRepository.findById(UUID.fromString(newSequelId)).orElse(null);
        if (newSequel == null) {
            newSequel = movieRepository.findById(UUID.fromString(newSequelId)).orElseThrow(() -> new ResourceNotFoundException(newSequelId + " not found"));
        }
        return newSequel;
    }

    private FilmEntity addPrequel(FilmDto filmDto) {
        String newPrequelId = filmDto.getPrequel();
        FilmEntity newPrequel = serieRepository.findById(UUID.fromString(newPrequelId)).orElse(null);

        if (newPrequel == null) {
            newPrequel = movieRepository.findById(UUID.fromString(newPrequelId)).orElseThrow(() -> new ResourceNotFoundException(newPrequelId + " not found"));
        }
        return newPrequel;
    }

    private SagaEntity createSaga(FilmDto filmDto, FilmEntity film) {
        SagaEntity newSaga = sagaRepository.findSagaByFilmId(film.getId().toString()).orElse(null);
        if (newSaga == null) {
            newSaga = new SagaEntity(filmDto.getSagaName(), film);
        } else {
            newSaga.setName(filmDto.getSagaName());
        }
        return newSaga;
    }
}

