package com.ToorenRomaros.api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ToorenRomaros.api.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID>{
	@Query("SELECT c FROM Comment c WHERE c.user = ?#{ authentication.name }")List<Comment> findAllByUser();
}
