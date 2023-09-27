package com.ToorenRomaros.api.repositories.user;

import com.ToorenRomaros.api.entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Query(nativeQuery = true , value = "SELECT u FROM user u WHERE u.username = ?1")
    List<UserEntity> findUserByUsername(String username);
}
