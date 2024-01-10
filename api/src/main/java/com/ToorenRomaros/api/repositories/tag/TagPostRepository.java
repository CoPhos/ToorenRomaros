package com.ToorenRomaros.api.repositories.tag;

import com.ToorenRomaros.api.entities.tag.TagPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagPostRepository extends JpaRepository<TagPostEntity, UUID> {
}
