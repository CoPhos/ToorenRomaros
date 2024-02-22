package com.ToorenRomaros.api.repositories.film;

import com.ToorenRomaros.api.entities.film.SagaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface SagaRepository extends JpaRepository<SagaEntity, UUID> {
    @Query(nativeQuery = true, value = "select * from saga s where s.film_id = ?1")
    Optional<SagaEntity> findSagaByFilmId(String id);
}
