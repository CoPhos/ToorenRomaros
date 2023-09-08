package com.ToorenRomaros.api.repositories;
import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserFollowerRepository extends JpaRepository<UserFollowerEntity, UUID> {

    @Query("select f.followers from UserFollowerEntity f where f.user = ?1")
    List<UserFollowerEntity> findAllFollowersOf(String username);

}
