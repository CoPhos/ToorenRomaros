package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.entities.publication.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {
    @Query(value =  "SELECT c FROM CommentEntity c LEFT JOIN FilmEntity f ON c.film.id=f.id WHERE c.user.id=?1 AND c.reported=?2 AND f.filmType=?3")
    Page<CommentEntity> getAllCommentsByUserIdAndReportedAndFilmType(UUID id, Boolean reported, int filmType, Pageable pageable);
    @Query("SELECT c FROM CommentEntity as c WHERE c.film.id = ?1 AND c.reported = ?2")
    Page<CommentEntity> getAllCommentsByFilmIdAndReported(UUID id, Boolean reported, Pageable pageable);
    @Query(nativeQuery = true, value = "SELECT * FROM comment as c WHERE c.film_id=?1 AND c.user_id=?2")
    Optional<CommentEntity> getCommentByFilmIdAndUserId(String film, String user);
    @Query("SELECT c FROM CommentEntity as c WHERE c.film.id = ?1 AND c.reported = ?2 AND c.rating<=?3 AND c.rating>=?4")
    Page<CommentEntity> getAllCommentByFilmIdAndRatingOrderByField(UUID id, Boolean reported, int maxRating, int lowRating, Pageable pageable);
    @Query(nativeQuery = true, value = "SELECT * FROM rating r WHERE user_id = ?1")
    List<CommentEntity> getAllRatingByUserId(String id);
    @Query(nativeQuery = true, value = "SELECT" +
            " SUM(CASE WHEN rating >= 70 THEN 1 ELSE 0 END), " +
            " SUM(CASE WHEN rating >= 40 and rating < 70  THEN 1 ELSE 0 END), " +
            " SUM(CASE WHEN rating < 40 THEN 1 ELSE 0 END) " +
            " FROM " +
            " comment " +
            " WHERE " +
            " film_id = ?1 AND reported=false")
    List<Object[]> getotalRatingsByFilmId(String id);
}
