package com.ToorenRomaros.api.repositories.media;

import com.ToorenRomaros.api.entities.media.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImageRepostiroy extends JpaRepository<ImageEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM image as i WHERE i.image_type=?1 AND i.owner_id=?2 order by CREATED_AT DESC")
    List<ImageEntity> findAllImageByImageType(String imageType, String ownerId);
    @Query(nativeQuery = true, value = "select distinct i.* from image as i inner join film_staff as fs on fs.staff_id = i.owner_id and i.image_type=?1 and fs.film_id=?2")
    List<ImageEntity> findAllImagesFromStaffByImageTypeAndFilmid(String imageType, String filmId);
    @Query(nativeQuery = true, value = "select distinct i.* from image as i inner join stream_film as fs on fs.stream_id=i.owner_id and i.image_type=?1 and fs.film_id=?2")
    List<ImageEntity> findAllImagesFromStreamSiteByImageTypeAndStreamSiteId(String imageType, String filmId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM image WHERE owner_id=?1")
    void deleteByOwnerId(String id);
}
