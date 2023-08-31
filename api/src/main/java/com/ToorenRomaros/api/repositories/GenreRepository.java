package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
}
