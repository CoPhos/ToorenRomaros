package com.ToorenRomaros.api.repositories.comment;

import com.ToorenRomaros.api.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

}
