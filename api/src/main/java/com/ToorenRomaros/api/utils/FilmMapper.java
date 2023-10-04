package com.ToorenRomaros.api.utils;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.SerieDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.Serie;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    private final ModelMapper modelMapper;

    public FilmMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

     public FilmEntity mapToFilmEntity(FilmDto filmDto){
        if(filmDto instanceof MovieDto) {
            return modelMapper.map(filmDto, Movie.class);
        }
        if(filmDto instanceof SerieDto){
            return modelMapper.map(filmDto, Serie.class);
        }
        return null;
    }

    public FilmDto mapToFilmDto(FilmEntity filmEntity){
        if(filmEntity instanceof Movie){
            FilmDto filmDto = modelMapper.map(filmEntity, MovieDto.class);
            filmDto.setFilmType(1);
            return filmDto;
        }
        if (filmEntity instanceof Serie){
            FilmDto filmDto = modelMapper.map(filmEntity, SerieDto.class);
            filmDto.setFilmType(2);
            return filmDto;
        }
        return null;
    }
}
