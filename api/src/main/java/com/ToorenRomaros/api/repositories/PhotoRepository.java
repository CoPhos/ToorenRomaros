package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.media.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhotoRepository extends JpaRepository<PhotoEntity, UUID> {
}
