package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.dto.publication.RatingDto;
import com.ToorenRomaros.api.entities.publication.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RatingRepository extends JpaRepository<RatingEntity, UUID> {
    @Query(nativeQuery = true, value = "select * from rating r where user_id = ?1")
    List<RatingEntity> getAllRatingByUserId(String id);
    @Query(nativeQuery = true, value = "select * from rating r where film_id = ?1 and super_rating = ?2")
    List<RatingEntity> getAllRatingByFilmIdAndRatingType(String id, Boolean superRating);
}
