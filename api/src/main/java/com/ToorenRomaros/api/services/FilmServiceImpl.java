package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.repositories.film.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService{
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public FilmServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public MovieDto createFilm(Movie movie) {
        //TODO use movieRequestDto. sequel and prequel need to be entities???
        return modelMapper.map(movieRepository.save(movie), MovieDto.class);
    }
}
