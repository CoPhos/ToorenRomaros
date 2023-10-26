package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.CommentDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);
    CommentDto getCommentById(UUID id);
    List<CommentDto> getAllCommentByUserId(UUID id);
    List<CommentDto> getAllCommentByFilmId(UUID id);
    CommentDto updateComment(UUID id, CommentDto commentDto);
    void deleteComment(UUID id);
}