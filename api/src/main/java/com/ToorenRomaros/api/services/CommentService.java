package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.CommentDto;
import com.ToorenRomaros.api.dto.publication.PostDetailsDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);
    CommentDto getCommentById(UUID id);
    List<CommentDto> getAllCommentByUserId(UUID id, String reported);
    Page<CommentDto> getAllCommentByFilmId(UUID id, Boolean reported, Pageable pageable);
    CommentDto updateComment(UUID id, CommentDto commentDto);
    Map<String, Object> getTotalRatingByFilmId(UUID id);
    void deleteComment(UUID id);
}
