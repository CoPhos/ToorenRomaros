package com.ToorenRomaros.api.config;

import com.ToorenRomaros.api.dto.UserDto;
import com.ToorenRomaros.api.dto.UserFollowerDto;
import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

        modelMapper.createTypeMap(UserEntity.class, UserDto.class)
                .addMapping(UserEntity::getFollowing,UserDto::setFollowing)
                .addMapping(UserEntity::getFollower, UserDto::setFollowers);

        modelMapper.createTypeMap(UserFollowerEntity.class, UserFollowerDto.class)
                .addMapping(UserFollowerEntity::getFollowing, UserFollowerDto::setFollowing)
                .addMapping(UserFollowerEntity::getFollower, UserFollowerDto::setFollower);
        return modelMapper;
    }
}
