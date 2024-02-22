package com.ToorenRomaros.api.repositories.film;

import com.ToorenRomaros.api.dao.FilmRepositoryCustom;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FilmRepository extends JpaRepository<FilmEntity, UUID>, FilmRepositoryCustom {
    @Query(nativeQuery = true, value = "SELECT * FROM film f WHERE f.saga_id = ?1")
    List<FilmEntity> findBySagaId(String id);
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE film f SET f.view_count = COALESCE(f.view_count, 0) + 1 WHERE f.id = ?1")
    void incrementViewCountByFilmId(String id);
}
