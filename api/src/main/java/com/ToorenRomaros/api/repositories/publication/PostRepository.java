package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<PostEntity, UUID> {

    @Query(nativeQuery = true, value = "SELECT tittle, headline FROM post where post.status='posted' ORDER BY publicationDateTime DESC LIMIT 8")
    List<PostEntity> getPostTittleAndPostHeadlineWhereStatusFinishedOrderByCreadtedDateDESCLimit8();
}
