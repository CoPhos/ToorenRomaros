package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.film.SagaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SagaRepository extends JpaRepository<SagaEntity, UUID> {
}
