package com.ToorenRomaros.api.repositories.genre;

import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.entities.genre.GenreFilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenreFilmRepository extends JpaRepository<GenreFilmEntity, UUID> {
    @Query(nativeQuery = true, value = "select * from genre_film s where s.film_id = ?1")
    List<GenreFilmEntity> findGenreByFilmId(String id);
}
