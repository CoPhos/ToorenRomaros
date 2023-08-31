package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.media.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhotoRepository extends JpaRepository<Photo, UUID> {
}
