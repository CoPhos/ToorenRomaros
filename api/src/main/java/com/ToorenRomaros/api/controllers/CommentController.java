package com.ToorenRomaros.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ToorenRomaros.api.entities.Comment;
import com.ToorenRomaros.api.services.CommentService;

@RestController 
@RequestMapping("/api/v1")
public class CommentController {
	
	@Autowired private CommentService commentService;

	@PostMapping("/") public void add(@RequestBody Comment comment) { 
		commentService.saveComment(comment);
	}

	@GetMapping("/") public List<Comment> findAll() { 
		return commentService.findComment();
	}
	@PreAuthorize("hasRole('adminrole')")
	@DeleteMapping("/{id}") public void delete(@PathVariable UUID id) {
		commentService.deleteComment(id);
	} 
	
	@GetMapping("/hello")
	public String hello() {
		return "hello there admin";
	}
}
