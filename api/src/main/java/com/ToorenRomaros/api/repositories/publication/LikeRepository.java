package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.entities.publication.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LikeRepository extends JpaRepository<LikeEntity, UUID> {
}
