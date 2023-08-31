package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.film.Saga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SagaRepository extends JpaRepository<Saga, UUID> {
}
