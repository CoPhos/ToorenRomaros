package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.publication.PublicationEntity;
import com.ToorenRomaros.api.entities.publication.RatingEntity;
import com.ToorenRomaros.api.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserEntityServiceTest {
    UserService userService;
    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        this.userService = new UserService(userRepository);

    }

    @Test
    void getUserByIdShouldReturnOneUser(){
        //given
        List<UserEntity> users = new ArrayList();
        List<PublicationEntity> publication = new ArrayList();
        List<RatingEntity> ratings = new ArrayList();
        UserEntity user1 = new UserEntity("alice", LocalDate.of(1990,05,15),LocalDate.of(2010,01,10),"I love Coding", 15, 0,users,users,publication, ratings);
        when(userRepository.findUserById("alice")).thenReturn(List.of(user1));

        //when
        List<UserEntity> userResult = userService.getUserById("alice");

        //then
        assertThat(userResult).containsExactly(user1);
    }
}