package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.MovieAddRequestDto;
import com.ToorenRomaros.api.dto.film.SerieAddRequestDto;
import com.ToorenRomaros.api.dto.film.SerieDto;
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
    public MovieDto createMovie(MovieAddRequestDto movieAddRequestDto) {
        Movie movie = modelMapper.map(movieAddRequestDto, Movie.class);
        if (movieAddRequestDto.getPrequel() != null) {
            UUID prequelId = UUID.fromString(movieAddRequestDto.getPrequel());
            Movie moviePrequel = movieRepository.findById(prequelId).orElse(null);

            if (moviePrequel == null) {
                Serie seriePrequel = serieRepository.findById(prequelId).orElseThrow(() -> new ResourceNotFoundException(prequelId.toString() + " not found"));
                movie.setPrequel(seriePrequel);
            } else {
                movie.setPrequel(moviePrequel);
            }
        }
        if (movieAddRequestDto.getSequel() != null) {
            UUID sequelId = UUID.fromString(movieAddRequestDto.getSequel());
            Movie movieSequel = movieRepository.findById(sequelId).orElse(null);
            if (movieSequel == null) {
                Serie serieSequel = serieRepository.findById(sequelId).orElseThrow(() -> new ResourceNotFoundException(sequelId.toString() + " not found"));
                movie.setSequel(serieSequel);
            } else {
                movie.setSequel(movieSequel);
            }
        }
        if (movie.getSaga() == null) {
            movie.setSaga(new ArrayList<>());
        }
        movieRepository.save(movie);
        if (movieAddRequestDto.getSagaName() != null) {
            SagaEntity saga = new SagaEntity(movieAddRequestDto.getSagaName(), movie);
            movie.getSaga().add(saga);
            sagaRepository.save(saga);
        }
        Movie savedMovie = movieRepository.save(movie);
        return modelMapper.map(savedMovie, MovieDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public SerieDto createSerie(SerieAddRequestDto serieAddRequestDto) {
        Serie serie = modelMapper.map(serieAddRequestDto, Serie.class);
        if (serieAddRequestDto.getPrequel() != null) {
            UUID prequelId = UUID.fromString(serieAddRequestDto.getPrequel());
            Serie seriePrequel = serieRepository.findById(prequelId).orElse(null);
            if (seriePrequel == null) {
                Movie moviePrequel = movieRepository.findById(prequelId).orElseThrow(() -> new ResourceNotFoundException(prequelId.toString() + " not found"));
                serie.setPrequel(moviePrequel);
            } else {
                serie.setPrequel(seriePrequel);
            }
        }
        if (serieAddRequestDto.getSequel() != null) {
            UUID sequelId = UUID.fromString(serieAddRequestDto.getSequel());
            Serie serieSequel = serieRepository.findById(sequelId).orElse(null);
            if (serieSequel == null) {
                Movie movieSequel = movieRepository.findById(sequelId).orElseThrow(() -> new ResourceNotFoundException(sequelId.toString() + " not found"));
                serie.setSequel(movieSequel);
            } else {
                serie.setSequel(serieSequel);
            }
        }
        if (serie.getSaga() == null) {
            serie.setSaga(new ArrayList<>());
        }
        serieRepository.save(serie);

        if (serieAddRequestDto.getSagaName() != null) {
            SagaEntity saga = new SagaEntity(serieAddRequestDto.getSagaName(), serie);
            serie.getSaga().add(saga);
            sagaRepository.save(saga);
        }
        Serie savedSerie = serieRepository.save(serie);
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
    public MovieDto updateMovie(UUID id, MovieAddRequestDto movieAddRequestDto) {
        Movie newMovie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        Movie movie = modelMapper.map(movieAddRequestDto, Movie.class);

        movie.setSaga(null);
        movie.setSequel(null);
        movie.setPrequel(null);

        BeanUtils.copyProperties(movie, newMovie, Utils.getNullPropertyNames(movie));
        movieRepository.save(newMovie);

        if (movieAddRequestDto.getSagaName() != null) {
            SagaEntity newSaga = sagaRepository.findSagaByFilmId(newMovie.getId().toString()).orElse(null);
            if (newSaga == null) {
                newSaga = new SagaEntity(movieAddRequestDto.getSagaName(), newMovie);
            } else {
                newSaga.setName(movieAddRequestDto.getSagaName());
            }
            newMovie.getSaga().add(newSaga);
            sagaRepository.save(newSaga);
        }
        if (movieAddRequestDto.getSequel() != null) {
            String newSequelId = movieAddRequestDto.getSequel();
            Movie newSequelSerie = movieRepository.findById(UUID.fromString(newSequelId)).orElse(null);

            if (newSequelSerie == null) {
                Serie newSequelMovie = serieRepository.findById(UUID.fromString(newSequelId)).orElseThrow(() -> new ResourceNotFoundException(newSequelId + " not found"));
                newMovie.setSequel(newSequelMovie);
            } else {
                newMovie.setSequel(newSequelSerie);
            }
        }
        if (movieAddRequestDto.getPrequel() != null) {
            String newPrequelId = movieAddRequestDto.getPrequel();
            Movie newPrequelSerie = movieRepository.findById(UUID.fromString(newPrequelId)).orElse(null);

            if (newPrequelSerie == null) {
                Serie newPrequelMovie = serieRepository.findById(UUID.fromString(newPrequelId)).orElseThrow(() -> new ResourceNotFoundException(newPrequelId + " not found"));
                newMovie.setPrequel(newPrequelMovie);
            } else {
                newMovie.setPrequel(newPrequelSerie);
            }
        }

        Movie savedMovie = movieRepository.save(newMovie);
        return modelMapper.map(savedMovie, MovieDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public SerieDto updateSerie(UUID id, SerieAddRequestDto serieAddRequestDto) {
        Serie newSerie = serieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tv Serie not found"));
        Serie serie = modelMapper.map(serieAddRequestDto, Serie.class);

        serie.setSaga(null);
        serie.setSequel(null);
        serie.setPrequel(null);

        BeanUtils.copyProperties(serie, newSerie, Utils.getNullPropertyNames(serie));
        serieRepository.save(newSerie);

        if (serieAddRequestDto.getSagaName() != null) {
            SagaEntity newSaga = sagaRepository.findSagaByFilmId(newSerie.getId().toString()).orElse(null);
            if (newSaga == null) {
                newSaga = new SagaEntity(serieAddRequestDto.getSagaName(), newSerie);
            } else {
                newSaga.setName(serieAddRequestDto.getSagaName());
            }
            newSerie.getSaga().add(newSaga);
            sagaRepository.save(newSaga);
        }
        if (serieAddRequestDto.getSequel() != null) {
            String newSequelId = serieAddRequestDto.getSequel();
            Serie newSequelSerie = serieRepository.findById(UUID.fromString(newSequelId)).orElse(null);

            if (newSequelSerie == null) {
                Movie newSequelMovie = movieRepository.findById(UUID.fromString(newSequelId)).orElseThrow(() -> new ResourceNotFoundException(newSequelId + " not found"));
                newSerie.setSequel(newSequelMovie);
            } else {
                newSerie.setSequel(newSequelSerie);
            }
        }
        if (serieAddRequestDto.getPrequel() != null) {
            String newPrequelId = serieAddRequestDto.getPrequel();
            Serie newPrequelSerie = serieRepository.findById(UUID.fromString(newPrequelId)).orElse(null);

            if (newPrequelSerie == null) {
                Movie newPrequelMovie = movieRepository.findById(UUID.fromString(newPrequelId)).orElseThrow(() -> new ResourceNotFoundException(newPrequelId + " not found"));
                newSerie.setPrequel(newPrequelMovie);
            } else {
                newSerie.setPrequel(newPrequelSerie);
            }
        }

        Serie savedSerie = serieRepository.save(newSerie);
        return modelMapper.map(savedSerie, SerieDto.class);
    }
}

