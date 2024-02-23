package com.ToorenRomaros.api.repositories.film;

import com.ToorenRomaros.api.entities.film.SagaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface SagaRepository extends JpaRepository<SagaEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM saga s WHERE s.film_id = ?1")
    Optional<SagaEntity> findByFilmId(String id);
}
