package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.media.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {
}
