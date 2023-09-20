package com.ToorenRomaros.api.config;

import com.ToorenRomaros.api.dto.UserDto;
import com.ToorenRomaros.api.dto.UserFollowerDto;
import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
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

        Converter<List<UserFollowerEntity>, List<UserFollowerDto>> converterFollowers = new AbstractConverter<List<UserFollowerEntity>, List<UserFollowerDto>>() {
            @Override
            protected List<UserFollowerDto> convert(List<UserFollowerEntity> source) {
                return source.stream().map(value -> {
                    UserFollowerDto nestedIdentity = new UserFollowerDto();
                    nestedIdentity.setFollower(value.getFollowing().getUsername());
                    nestedIdentity.setCreatedDate(value.getFollowDate());
                    return nestedIdentity;
                }).collect(Collectors.toList());
            }
        };

        Converter<List<UserFollowerEntity>, List<UserFollowerDto>> converterFollowings = new AbstractConverter<List<UserFollowerEntity>, List<UserFollowerDto>>() {
            @Override
            protected List<UserFollowerDto> convert(List<UserFollowerEntity> source) {
                return source.stream().map(value -> {
                    UserFollowerDto nestedIdentity = new UserFollowerDto();
                    nestedIdentity.setFollower(value.getFollower().getUsername());
                    nestedIdentity.setCreatedDate(value.getFollowDate());
                    return nestedIdentity;
                }).collect(Collectors.toList());
            }
        };

        modelMapper.typeMap(UserEntity.class, UserDto.class).
                addMappings(mapper -> mapper.using(converterFollowers)
                        .map(UserEntity::getFollowers, UserDto::setFollowers))
                .addMappings(mapper -> mapper.using(converterFollowings)
                        .map(UserEntity::getFollowings, UserDto::setFollowings));;

        return modelMapper;
    }
}
