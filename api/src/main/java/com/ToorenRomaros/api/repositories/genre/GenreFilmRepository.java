package com.ToorenRomaros.api.repositories.genre;

import com.ToorenRomaros.api.entities.genre.GenreFilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GenreFilmRepository extends JpaRepository<GenreFilmEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM genre_film s WHERE s.film_id = ?1")
    List<GenreFilmEntity> findAllByFilmId(String id);
}
