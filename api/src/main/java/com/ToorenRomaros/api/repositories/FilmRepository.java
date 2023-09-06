package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilmRepository extends JpaRepository<FilmEntity, UUID> {
}
