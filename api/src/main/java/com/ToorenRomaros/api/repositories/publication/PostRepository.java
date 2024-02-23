package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.dao.PostRepositoryCustom;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<PostEntity, UUID>, PostRepositoryCustom {
    @Query(nativeQuery = true, value = "SELECT" +
            " SUM(CASE WHEN rating >= 70 THEN 1 ELSE 0 END), " +
            " SUM(CASE WHEN rating >= 40 and rating < 70  THEN 1 ELSE 0 END), " +
            " SUM(CASE WHEN rating < 40 THEN 1 ELSE 0 END) " +
            " FROM " +
            " post " +
            " WHERE " +
            " film_id = ?1 AND is_review=true AND status='PUBLISHED'")
    List<Object[]> getotalRatingsByFilmId(String id);

    @Query("select new com.ToorenRomaros.api.entities.publication.PostEntity(p.id, p.rating, p.publicationDateTime, p.synthesis, p.user) " +
            "FROM PostEntity as p " +
            "where p.film.id=?1 and p.isReview=TRUE and p.status='PUBLISHED'")
    Page<PostEntity> getReviewPostsByFilmId(UUID id, Pageable pageable);

    @Query(nativeQuery = true,value = "select * from post where user_id=?1 and film_id=?2 and rating is not null and rating>=0 order by publication_datetime DESC limit 1")
    Optional<PostEntity> getLatestReviewPostByFilmIdAndUserIdAndRatingNotNull(String userId, String filmId);

    @Query("select new com.ToorenRomaros.api.entities.publication.PostEntity(p.id, p.rating, p.publicationDateTime, p.synthesis, p.user) " +
            "FROM PostEntity as p " +
            "where p.film.id=?1 and p.isReview=TRUE and p.status='PUBLISHED' and p.rating<=?2 and p.rating>=?3 ")
    Page<PostEntity> getReviewPostsByFilmIdAndRatingOrderByField(UUID id, int maxRating, int lowRating, Pageable pageable);

    @Query("SELECT p FROM PostEntity p WHERE p.user.id=?1 and p.film.filmType=?2")
    Page<PostEntity> getLatestReviewsByUserIdAndFilmType(UUID userId, int filmType, Pageable pageable);
    @Query("SELECT p FROM PostEntity p WHERE p.user.id=?1 and p.status='DRAFT'")
    Page<PostEntity> getLatestDraftsByUserId(UUID userId, Pageable pageable);


}
