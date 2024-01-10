package com.ToorenRomaros.api.repositories.tag;

import com.ToorenRomaros.api.entities.tag.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<TagEntity, UUID> {
}
