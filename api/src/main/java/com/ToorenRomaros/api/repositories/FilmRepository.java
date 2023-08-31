package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilmRepository extends JpaRepository<Film, UUID> {
}
