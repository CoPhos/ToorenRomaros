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
    @Query(nativeQuery = true, value = "SELECT" +
            " SUM(CASE WHEN rating >= 70 AND super_rating = 1 THEN 1 ELSE 0 END), " +
            " SUM(CASE WHEN rating >= 40 and rating < 70 AND super_rating = 1 THEN 1 ELSE 0 END), " +
            " SUM(CASE WHEN rating < 40 AND super_rating = 1 THEN 1 ELSE 0 END), " +
            " SUM(CASE WHEN rating >= 70 AND super_rating = 0 THEN 1 ELSE 0 END), " +
            " SUM(CASE WHEN rating >= 40 and rating < 70 AND super_rating = 0 THEN 1 ELSE 0 END), " +
            " SUM(CASE WHEN rating < 40 AND super_rating = 0 THEN 1 ELSE 0 END) " +
            " FROM " +
            " rating " +
            " WHERE " +
            " film_id = ?1")
    List<Object[]> getotalRatingsByFilmIdAndRatingType(String id);
}
