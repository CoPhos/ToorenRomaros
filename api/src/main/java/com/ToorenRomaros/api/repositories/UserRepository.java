package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Query("SELECT u FROM UserEntity u WHERE u.username = ?1")
    List<UserEntity> findUserById(String username);

}
