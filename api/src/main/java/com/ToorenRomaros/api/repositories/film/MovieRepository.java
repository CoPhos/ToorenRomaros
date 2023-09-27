package com.ToorenRomaros.api.repositories.film;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
}
