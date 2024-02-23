package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.CreateCommentDto;
import com.ToorenRomaros.api.dto.publication.GetCommentDto;
import com.ToorenRomaros.api.dto.publication.UpdateCommentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface CommentService {
    GetCommentDto createComment(CreateCommentDto createCommentDto);
    GetCommentDto getCommentById(UUID id);
    Page<GetCommentDto> getAllCommentsByUserIdAndReportedAndFilmType(UUID id, Boolean reported, int filmType, Pageable pageable);
    GetCommentDto getCommentByFilmIdAndUserId(UUID filmId, UUID userId);
    Page<GetCommentDto> getAllCommentByFilmId(UUID id, Boolean reported, Pageable pageable);
    Page<GetCommentDto> getAllCommentByFilmIdAndRatingOrderByField(UUID id, Boolean reported, String rating, Pageable pageable);
    GetCommentDto updateComment(UUID id, UpdateCommentDto updateCommentDto);
    Map<String, Object> getTotalRatingByFilmId(UUID id);
    void deleteComment(UUID id);
}
