package com.ToorenRomaros.api.repositories.media;

import com.ToorenRomaros.api.entities.media.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoRepository extends JpaRepository<VideoEntity, UUID> {
}
