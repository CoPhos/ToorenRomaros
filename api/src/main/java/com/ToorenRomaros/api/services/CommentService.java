package com.ToorenRomaros.api.services;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ToorenRomaros.api.entities.Comment;
import com.ToorenRomaros.api.repositories.CommentRepository;
import java.util.Iterator;

@Service
public class CommentService {
	@Autowired private CommentRepository commentRepository;

	@PreAuthorize("#comment.user == authentication.name")
	public void saveComment(Comment comment) { 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> collection = authentication.getAuthorities();
		Iterator<? extends GrantedAuthority> iterator = collection.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		String login = authentication.getName();
		System.out.println(login);
		
		commentRepository.save(comment);
	}
	
	public List<Comment> findComment() { 
		return commentRepository.findAllByUser();
	}
	
	public void deleteComment(UUID id) {
		commentRepository.deleteById(id);
	}
}
