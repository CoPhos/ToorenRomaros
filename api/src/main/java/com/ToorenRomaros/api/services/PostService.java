package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.GetPostDetailsDto;
import com.ToorenRomaros.api.dto.publication.CreatePostDto;
import com.ToorenRomaros.api.dto.publication.GetPostDto;
import com.ToorenRomaros.api.dto.publication.UpdatePostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PostService {
    GetPostDto createPost(CreatePostDto createPostDto);
    GetPostDto getPostById(UUID id);
    GetPostDto updatePostById(UUID id, UpdatePostDto postDto);
    Map<String, Object>getTotalRatingByFilmId(UUID id);
    Page<GetPostDetailsDto> getReviewPostsByFilmId(UUID id, Pageable pageable);
    Page<GetPostDetailsDto> getReviewPostsByFilmIdAndRatingOrderByField(UUID id, String rating, Pageable pageable);
    Page<GetPostDetailsDto> getLatestReviewsByUserIdAndFilmType(UUID userId, int filmType, Pageable pageable);
    Page<GetPostDetailsDto> getLatestDraftsByUserId(UUID userId, Pageable pageable);
    GetPostDetailsDto getLatestReviewPostByFilmIdAndUserIdAndRatingNotNull(UUID userId, UUID filmId);
    Map<String, Object> getPostByCustomQuery(List<UUID> tags, boolean isReview, boolean latest, boolean popular, String searchQuery, int page, int size) throws SQLException;
    void deletePostById(UUID id);
}
