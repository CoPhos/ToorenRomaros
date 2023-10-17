package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.entities.publication.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {
}
