package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.PostDetailsDto;
import com.ToorenRomaros.api.dto.publication.PostDto;
import com.ToorenRomaros.api.dto.publication.UpdatePostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById(UUID id);
    PostDto updatePostById(UUID id, UpdatePostDto postDto);
    Map<String, Object>getTotalRatingByFilmId(UUID id);
    Page<PostDetailsDto> getReviewPostsByFilmId(UUID id, Pageable pageable);
    Page<PostDetailsDto> getReviewPostsByFilmIdAndRatingOrderByField(UUID id, String rating, Pageable pageable);
    PostDetailsDto getLatestReviewPostByFilmIdAndUserIdAndRatingNotNull(UUID userId, UUID filmId);
    Map<String, Object> getPostByCustomQuery(List<UUID> tags, boolean isReview, boolean latest, boolean popular, int page, int size);
    void deletePostById(UUID id);
}
