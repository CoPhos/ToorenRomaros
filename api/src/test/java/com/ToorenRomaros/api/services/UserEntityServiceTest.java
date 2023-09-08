package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.entities.publication.PublicationEntity;
import com.ToorenRomaros.api.entities.publication.RatingEntity;
import com.ToorenRomaros.api.repositories.UserFollowerRepository;
import com.ToorenRomaros.api.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserEntityServiceTest {
    UserService userService;
    @Mock
    UserRepository userRepository;
    @Mock
    UserFollowerRepository userFollowerRepository;

    @BeforeEach
    void setUp() {
        this.userService = new UserService(userRepository, userFollowerRepository);
    }

    @Test
    void addFollowerShouldWork(){
        //given
        UserEntity user1 = new UserEntity("alice", LocalDate.of(1990,05,15),LocalDate.of(2010,01,10),"I love Coding", 15, 0,null,null, null);
        UserEntity follower1 = new UserEntity("patrick", LocalDate.of(1990,05,15),LocalDate.of(2010,01,10),"I love Coding", 15, 0,null,null, null);
        UserFollowerEntity userFollowerEntity= new UserFollowerEntity();
        userFollowerEntity.setFollower(follower1);
        userFollowerEntity.setUser(user1);

        //when
        userService.addFollower(userFollowerEntity);

        //then
        verify(userFollowerRepository).save(userFollowerEntity);
    }

    @Test
    void getFollowersShouldReturnAllFollowersOfAUser(){
        //given
        UserEntity user1 = new UserEntity("alice", LocalDate.of(1990,05,15),LocalDate.of(2010,01,10),"I love Coding", 15, 0,null,null, null);
        UserEntity follower1 = new UserEntity("patrick", LocalDate.of(1990,05,15),LocalDate.of(2010,01,10),"I love Coding", 15, 0,null,null, null);
        UserFollowerEntity userFollowerEntity= new UserFollowerEntity();
        userFollowerEntity.setFollower(follower1);
        userFollowerEntity.setUser(user1);
        userService.addFollower(userFollowerEntity);

        //when
        List<UserFollowerEntity> followersResult = userService.findAllFollowersOf("alice");
        System.out.println("###########################################################");
        System.out.println("###########################################################");
        System.out.println("###########################################################");
        System.out.println(followersResult.toString());
        System.out.println("###########################################################");
        System.out.println("###########################################################");
        System.out.println("###########################################################");

        //then
        assertThat(followersResult).isNotEmpty();
    }

    @Test
    void getUserByIdShouldReturnOneUser(){
        //given
        List<PublicationEntity> publication = new ArrayList();
        List<RatingEntity> ratings = new ArrayList();
        UserEntity user1 = new UserEntity("alice", LocalDate.of(1990,05,15),LocalDate.of(2010,01,10),"I love Coding", 15, 0,null,publication, ratings);
        when(userRepository.findById("alice")).thenReturn(Optional.of(user1));

        //when
        Optional<UserEntity> userResult = userService.getUserById("alice");

        //then
        assertThat(userResult).contains(user1);
    }

    @Test
    void deletingAUserShouldWork(){
        //given
        List<PublicationEntity> publication = new ArrayList();
        List<RatingEntity> ratings = new ArrayList();
        UserEntity user1 = new UserEntity("alice", LocalDate.of(1990,05,15),LocalDate.of(2010,01,10),"I love Coding", 15, 0,null,publication, ratings);
        when(userRepository.findById("alice")).thenReturn(Optional.of(user1));

        //when
        userService.deleteUserById("alice");

        //then
        verify(userRepository).findById("alice");
        verify(userRepository).delete(user1);
    }
}