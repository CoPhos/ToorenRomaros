package com.ToorenRomaros.api.repositories.media;

import com.ToorenRomaros.api.entities.media.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImageRepostiroy extends JpaRepository<ImageEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM image as i WHERE i.image_type=?1 AND i.owner_id=?2")
    List<ImageEntity> findAllImageByImageType(String imageType, String ownerId);
}
