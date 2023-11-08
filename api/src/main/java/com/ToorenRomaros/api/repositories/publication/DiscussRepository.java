package com.ToorenRomaros.api.repositories.publication;

import com.ToorenRomaros.api.entities.publication.DiscussEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DiscussRepository extends JpaRepository<DiscussEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM discuss WHERE discuss.post_id=?1 and discuss.reported=?2")
    List<DiscussEntity> findAllDiscussByPostId(String postId, boolean reported);

    @Query(nativeQuery = true, value = "SELECT * FROM discuss as d " +
            "JOIN parent_child_discuss p " +
            "ON d.id = p.child_discuss_id " +
            "WHERE p.parent_discuss_id=?1 and c.reported=?2")
    List<DiscussEntity> findAllChildDiscussByParentDiscussId(String parentId, boolean reported);
}
