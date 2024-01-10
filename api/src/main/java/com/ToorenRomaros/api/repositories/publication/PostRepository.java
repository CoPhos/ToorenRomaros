package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.dao.PostRepositoryCustom;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<PostEntity, UUID>, PostRepositoryCustom {
}
