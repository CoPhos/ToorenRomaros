package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.UserFollowerEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserFollowerRepository extends JpaRepository<UserFollowerEntity, UUID> {
    @Query(nativeQuery = true, value = "select * from user_follower u where u.user_id = ?1 ORDER BY ?#{#pageable}", countQuery = "select count(*) from user_follower")
    List<UserFollowerEntity> findAllFollowersByUser(String id, Pageable pageable);

}
