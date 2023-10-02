package com.ToorenRomaros.api.repositories.film;

import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SerieRepository extends JpaRepository<Serie, UUID> {

}
