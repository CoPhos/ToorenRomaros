package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.entities.publication.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<PostEntity, UUID> {
}
