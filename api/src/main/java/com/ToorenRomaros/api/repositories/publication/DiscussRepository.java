package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.entities.publication.DiscussEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiscussRepository extends JpaRepository<DiscussEntity, UUID> {
}
