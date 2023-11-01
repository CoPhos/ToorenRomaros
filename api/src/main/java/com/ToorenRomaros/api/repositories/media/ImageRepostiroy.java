package com.ToorenRomaros.api.repositories.media;

import com.ToorenRomaros.api.entities.media.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ImageRepostiroy extends JpaRepository<ImageEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM image as i where " +
            "i.owner_id=?1 and i.image_type=\"profile\" and i.size=?2 and i.owner_type=\"U\" " +
            "ORDER BY i.created_at DESC LIMIT 1")
    Optional<ImageEntity> findProfilePhotoByUserId(String userId, String imageSize);
}
