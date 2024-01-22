package com.ToorenRomaros.api.utils;

import com.ToorenRomaros.api.dto.film.*;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.services.FilmServiceImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    private final ModelMapper modelMapper;

    public FilmMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    private static final Logger log = LoggerFactory.getLogger(FilmMapper.class);
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
        try{
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
        }catch (Exception e){
            log.info(e.getMessage());
            log.info(String.valueOf(e.getCause()));
        }
        return null;
    }
    public GetDynamicQyeryFilmDto mapToGetDynamicQueryFilmDto(FilmEntity filmEntity){
        if(filmEntity instanceof Movie){
            GetDynamicQyeryFilmDto filmDto = modelMapper.map(filmEntity, GetDynamicQueryMovieDto.class);
            filmDto.setFilmType(1);
            return filmDto;
        }
        if (filmEntity instanceof Serie){
            GetDynamicQyeryFilmDto filmDto = modelMapper.map(filmEntity, GetDynamicQuerySerieDto.class);
            filmDto.setFilmType(2);
            return filmDto;
        }
        return null;
    }
}
