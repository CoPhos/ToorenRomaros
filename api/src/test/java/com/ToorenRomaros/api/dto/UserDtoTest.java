package com.ToorenRomaros.api.dto;

import com.ToorenRomaros.api.config.AppConfig;
import com.ToorenRomaros.api.dto.user.UserDto;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {

    private ModelMapper mapper;

    @BeforeEach
    public void setup(){
        this.mapper = new AppConfig().modelMapper();
    }

    @Test
    public void whenMappingUserThenConvertsToDtoShouldWork(){
        //given
        UserEntity user1 = new UserEntity(
                "alice",
                LocalDate.of(1990, 5, 8),
                LocalDate.of(2023, 9, 16),
                "I love coding", 0, 0, new ArrayList<UserFollowerEntity>(), new ArrayList<UserFollowerEntity>());

        UserEntity user2 = new UserEntity(
                "Enapril",
                LocalDate.of(1990, 5, 8),
                LocalDate.of(2023, 9, 16),
                "I love pot", 0, 0, new ArrayList<UserFollowerEntity>(), new ArrayList<UserFollowerEntity>());
        UserEntity user3 = new UserEntity(
                "Benzafibrato",
                LocalDate.of(1990, 5, 8),
                LocalDate.of(2023, 9, 16),
                "I love EDM Music", 0, 0, new ArrayList<UserFollowerEntity>(), new ArrayList<UserFollowerEntity>());

        user1.getFollowers().add(new UserFollowerEntity(LocalDate.now(), user1, user2));
        user1.getFollowers().add(new UserFollowerEntity(LocalDate.now(), user1, user3));
        user1.getFollowings().add(new UserFollowerEntity(LocalDate.now(), user1, user2));

        //when
        UserDto user1Dto = this.mapper.map(user1, UserDto.class);

        //then
        assertEquals(user1.getUsername(), user1Dto.getUsername());
        assertEquals(user1.getBirthday(), user1Dto.getBirthday());
        assertEquals(user1.getFollowingCount(), user1Dto.getFollowingCount());
        assertEquals(user1.getFollowmeCount(), user1Dto.getFollowmeCount());
        assertEquals(user1.getAbout(), user1Dto.getAbout());
        assertEquals(user1.getCreatedDate(), user1Dto.getCreatedDate());
    }

}