package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.publication.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM comment WHERE comment.user_id = ?1 and comment.reported = ?2")
    List<CommentEntity> getAllCommentsByUserIdAndReported(String id, String reported);

    @Query(nativeQuery = true, value = "SELECT * FROM comment WHERE comment.film_id = ?1 and comment.reported = ?2")
    List<CommentEntity> getAllCommentsByFilmIdAndReported(String id, Boolean reported);

    @Query(nativeQuery = true, value = "select * from rating r where user_id = ?1")
    List<CommentEntity> getAllRatingByUserId(String id);
    @Query(nativeQuery = true, value = "SELECT" +
            " SUM(CASE WHEN rating >= 70 THEN 1 ELSE 0 END), " +
            " SUM(CASE WHEN rating >= 40 and rating < 70  THEN 1 ELSE 0 END), " +
            " SUM(CASE WHEN rating < 40 THEN 1 ELSE 0 END), " +
            " FROM " +
            " rating " +
            " WHERE " +
            " film_id = ?1 AND reported=false")
    List<Object[]> getotalRatingsByFilmId(String id);
}
