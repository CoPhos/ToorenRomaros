package com.ToorenRomaros.api.repositories.user;

import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserFollowerRepository extends JpaRepository<UserFollowerEntity, UUID> {
    @Query(nativeQuery = true, value = "select * from user_follower u where u.user_id = ?1 ORDER BY ?#{#pageable}", countQuery = "select count(*) from user_follower")
    List<UserFollowerEntity> findAllFollowersByUser(String id, Pageable pageable);
    @Query(nativeQuery = true, value = "select * from user_follower u where u.follower_id = ?1 ORDER BY ?#{#pageable}", countQuery = "select count(*) from user_follower")
    List<UserFollowerEntity> findAllFollowingsByUser(String id, Pageable pageable);
    @Query(nativeQuery = true, value = "select * from user_follower u where u.user_id = ?1 and u.follower_id = ?2")
    Optional<UserFollowerEntity> findByUserIdAndFollowId(String userId, String followId);

}
