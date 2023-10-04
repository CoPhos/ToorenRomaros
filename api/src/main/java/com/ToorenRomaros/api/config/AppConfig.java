package com.ToorenRomaros.api.config;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.SagaDto;
import com.ToorenRomaros.api.dto.film.SerieDto;
import com.ToorenRomaros.api.dto.user.UserAddRequestDto;
import com.ToorenRomaros.api.dto.user.UserDto;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.dto.user.UserFollowingDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Configuration
public class AppConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        //User
        TypeMap<UserFollowerEntity, UserFollowerDto> propertyMapperFollower = modelMapper.createTypeMap(UserFollowerEntity.class, UserFollowerDto.class);
        propertyMapperFollower.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFollower().getUsername(), UserFollowerDto::setFollower);
                    mapper.map(UserFollowerEntity::getFollowDate, UserFollowerDto::setFollowDate);
                }
        );
        TypeMap<UserFollowerEntity, UserFollowingDto> propertyMapperFollowing = modelMapper.createTypeMap(UserFollowerEntity.class, UserFollowingDto.class);
        propertyMapperFollowing.addMappings(
                mapper -> {
                    mapper.map(src -> src.getUser().getUsername(), UserFollowingDto::setFollowing);
                    mapper.map(UserFollowerEntity::getFollowDate, UserFollowingDto::setFollowDate);
                }
        );

        //Film
        TypeMap<Movie, MovieDto> propertyMapperMoviePrequelSequel = modelMapper.createTypeMap(Movie.class, MovieDto.class);
        propertyMapperMoviePrequelSequel.addMappings(
                mapper -> {
                    mapper.map(src -> src.getPrequel().getTittle(), MovieDto::setPrequel);
                    mapper.map(src -> src.getSequel().getTittle(), MovieDto::setSequel);
                }
        );
        TypeMap<Serie, SerieDto> propertyMapperSeriePrequelSequel = modelMapper.createTypeMap(Serie.class, SerieDto.class);
        propertyMapperSeriePrequelSequel.addMappings(
                mapper -> {
                    mapper.map(src -> src.getPrequel().getTittle(), SerieDto::setPrequel);
                    mapper.map(src -> src.getSequel().getTittle(), SerieDto::setSequel);
                }
        );

        return modelMapper;
    }
}
