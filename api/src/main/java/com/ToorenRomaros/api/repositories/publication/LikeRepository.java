package com.ToorenRomaros.api.repositories.publication;


import com.ToorenRomaros.api.entities.publication.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface LikeRepository extends JpaRepository<LikeEntity, UUID> {

    @Query("Select c FROM LikeEntity as c WHERE c.owner.id = ?1 and c.user.id = ?2")
    Optional<LikeEntity> getCommentByOwnerIdAndUserId(UUID ownerId, UUID userId);
}
