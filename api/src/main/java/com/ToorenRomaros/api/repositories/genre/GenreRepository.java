package com.ToorenRomaros.api.repositories.genre;

import com.ToorenRomaros.api.entities.genre.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<GenreEntity, UUID> {
}
