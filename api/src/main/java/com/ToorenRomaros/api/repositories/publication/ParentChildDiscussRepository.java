package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.entities.publication.ParentChildDiscussEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParentChildDiscussRepository extends JpaRepository<ParentChildDiscussEntity, UUID> {
}
