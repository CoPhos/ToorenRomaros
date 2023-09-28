package com.ToorenRomaros.api.config;

import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.SagaDto;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
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

//        Converter<List<UserFollowerEntity>, List<UserFollowerDto>> converterFollowers = new AbstractConverter<List<UserFollowerEntity>, List<UserFollowerDto>>() {
//            @Override
//            protected List<UserFollowerDto> convert(List<UserFollowerEntity> source) {
//                return source.stream().map(value -> {
//                    UserFollowerDto nestedIdentity = new UserFollowerDto();
//                    nestedIdentity.setFollower(value.getUser().getUsername());
//                    nestedIdentity.setFollowDate(value.getFollowDate());
//                    return nestedIdentity;
//                }).collect(Collectors.toList());
//            }
//        };
//
//        Converter<List<UserFollowerEntity>, List<UserFollowerDto>> converterFollowings = new AbstractConverter<List<UserFollowerEntity>, List<UserFollowerDto>>() {
//            @Override
//            protected List<UserFollowerDto> convert(List<UserFollowerEntity> source) {
//                return source.stream().map(value -> {
//                    UserFollowerDto nestedIdentity = new UserFollowerDto();
//                    nestedIdentity.setFollower(value.getUser().getUsername());
//                    nestedIdentity.setFollowDate(value.getFollowDate());
//                    return nestedIdentity;
//                }).collect(Collectors.toList());
//            }
//        };
//        modelMapper.typeMap(UserEntity.class, UserDto.class).
//                addMappings(mapper -> mapper.using(converterFollowers)
//                        .map(UserEntity::getFollowers, UserDto::setFollowers))
//                .addMappings(mapper -> mapper.using(converterFollowings)
//                        .map(UserEntity::getFollowings, UserDto::setFollowings));
        Converter<List<SagaEntity>, List<SagaDto>> converterSaga = new AbstractConverter<List<SagaEntity>, List<SagaDto>>() {
            @Override
            protected List<SagaDto> convert(List<SagaEntity> source) {
                return source.stream().map(value -> {
                    SagaDto nestedIdentity = new SagaDto();
                    nestedIdentity.setFilm(value.getFilm().getTittle());
                    nestedIdentity.setSagaName(value.getName());
                    return nestedIdentity;
                }).collect(Collectors.toList());
            }
        };


//        modelMapper.typeMap(FilmEntity.class, FilmDto.class).
//                addMappings(mapper -> mapper.using(converterSaga)
//                        .map(FilmEntity::getSaga, FilmDto::setSaga));

        //User
        TypeMap<UserFollowerEntity, UserFollowerDto> propertyMapperFollower = modelMapper.createTypeMap(UserFollowerEntity.class, UserFollowerDto.class);
        propertyMapperFollower.addMappings(
                mapper -> mapper.map(src -> src.getFollower().getUsername(), UserFollowerDto::setFollower)
        );

        //Film
        TypeMap<Movie, MovieDto> propertyMapperPrequelSequel = modelMapper.createTypeMap(Movie.class, MovieDto.class);
        propertyMapperPrequelSequel.addMappings(
                mapper -> {
                    mapper.map(src -> src.getPrequel().getTittle(), MovieDto::setPrequel);
                    mapper.map(src -> src.getSequel().getTittle(), MovieDto::setSequel);
                    mapper.using(converterSaga)
                            .map(Movie::getSaga, MovieDto::setSaga);
                }
        );

        return modelMapper;
    }
}
