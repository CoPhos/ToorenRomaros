package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query("select uf.username_follower from userFollowerEntity where u.username = ?1")
    List<UserEntity> findAllFollowersOf(String username);

}
