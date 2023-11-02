package com.ToorenRomaros.api.repositories.media;

import com.ToorenRomaros.api.entities.media.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImageRepostiroy extends JpaRepository<ImageEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM image as i where" +
            " i.owner_id=?1 and i.image_type=?2 and i.size=?3 and i.owner_type=?4" +
            " ORDER BY i.created_at DESC LIMIT 1")
    Optional<ImageEntity> findLatestImageFromImageByOwnerIdTypeSizeOwnerType(String ownerId, String type, String size, String ownerType);

    @Query(nativeQuery = true, value = "SELECT * FROM image as i where" +
            " i.owner_id=?1 and i.image_type=?2 and i.size=?3 and i.owner_type=?4" +
            " ORDER BY i.created_at DESC")
    List<ImageEntity> findAllImagesFromImageByOwnerIdTypeSizeOwnerType(String ownerId, String type, String size, String ownerType);
}
