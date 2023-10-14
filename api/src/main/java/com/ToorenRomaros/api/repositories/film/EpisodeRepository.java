package com.ToorenRomaros.api.repositories.film;

import com.ToorenRomaros.api.entities.film.EpisodeEntity;
import com.ToorenRomaros.api.entities.film.SagaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EpisodeRepository extends JpaRepository<EpisodeEntity, UUID> {
    @Query(nativeQuery = true, value = "select * from episode e where e.serie_id = ?1")
    List<EpisodeEntity> findAllEpisodesBYSerieId(String id);
}
