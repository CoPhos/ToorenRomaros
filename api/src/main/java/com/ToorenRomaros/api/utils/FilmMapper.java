package com.ToorenRomaros.api.utils;

import com.ToorenRomaros.api.dto.film.*;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.Serie;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {
    private final ModelMapper modelMapper;
    public FilmMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FilmEntity mapUpdateFilmDtoToFilmEntity(UpdateFilmDto updateFilmDto) {
        if (updateFilmDto instanceof UpdateMovieDto) {
            return modelMapper.map(updateFilmDto, Movie.class);
        }
        if (updateFilmDto instanceof UpdateSerieDto) {
            return modelMapper.map(updateFilmDto, Serie.class);
        }
        return null;
    }
    public UpdateFilmDto mapFilmEntityToUpdateFilmDto(FilmEntity filmEntity) {
        if (filmEntity instanceof Movie) {
            UpdateFilmDto updateFilmDto = modelMapper.map(filmEntity, UpdateMovieDto.class);
            updateFilmDto.setFilmType(1);
            return updateFilmDto;
        }
        if (filmEntity instanceof Serie) {
            UpdateFilmDto updateFilmDto = modelMapper.map(filmEntity, UpdateSerieDto.class);
            updateFilmDto.setFilmType(2);
            return updateFilmDto;
        }
        return null;
    }
    public FilmEntity mapCreateFilmDtoToFilmEntity(CreateFilmDto createFilmDto) {
        if (createFilmDto instanceof CreateMovieDto) {
            return modelMapper.map(createFilmDto, Movie.class);
        }
        if (createFilmDto instanceof CreateSerieDto) {
            return modelMapper.map(createFilmDto, Serie.class);
        }
        return null;
    }
    public CreateFilmDto mapFilmEntityToCreateFilmDto(FilmEntity filmEntity) {
        if (filmEntity instanceof Movie) {
            CreateFilmDto createFilmDto = modelMapper.map(filmEntity, CreateMovieDto.class);
            createFilmDto.setFilmType(1);
            return createFilmDto;
        }
        if (filmEntity instanceof Serie) {
            CreateFilmDto createFilmDto = modelMapper.map(filmEntity, CreateSerieDto.class);
            createFilmDto.setFilmType(2);
            return createFilmDto;
        }
        return null;
    }
    public GetFilmDto mapFilmEntityToGetFilmDto(FilmEntity filmEntity) {
        if (filmEntity instanceof Movie) {
            GetFilmDto getFilmDto = modelMapper.map(filmEntity, GetMovieDto.class);
            getFilmDto.setFilmType(1);
            return getFilmDto;
        }
        if (filmEntity instanceof Serie) {
            GetFilmDto getFilmDto = modelMapper.map(filmEntity, GetSerieDto.class);
            getFilmDto.setFilmType(2);
            return getFilmDto;
        }
        return null;
    }
    public GetDynamicQyeryFilmDto mapToGetDynamicQueryFilmDto(FilmEntity filmEntity) {
        if (filmEntity instanceof Movie) {
            GetDynamicQyeryFilmDto filmDto = modelMapper.map(filmEntity, GetDynamicQueryMovieDto.class);
            filmDto.setFilmType(1);
            return filmDto;
        }
        if (filmEntity instanceof Serie) {
            GetDynamicQyeryFilmDto filmDto = modelMapper.map(filmEntity, GetDynamicQuerySerieDto.class);
            filmDto.setFilmType(2);
            return filmDto;
        }
        return null;
    }
}
