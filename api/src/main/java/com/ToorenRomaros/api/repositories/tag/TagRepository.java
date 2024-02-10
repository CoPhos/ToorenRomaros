package com.ToorenRomaros.api.repositories.tag;

import com.ToorenRomaros.api.entities.tag.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface TagRepository extends JpaRepository<TagEntity, UUID> {
    @Query(nativeQuery = true, value = "select * from tag where tag=?1")
    Optional<TagEntity> getTagByName(String name);
}
