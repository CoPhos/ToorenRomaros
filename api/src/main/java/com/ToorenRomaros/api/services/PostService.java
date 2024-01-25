package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.PostDetailsDto;
import com.ToorenRomaros.api.dto.publication.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById(UUID id);
    PostDto updatePostById(UUID id, PostDto postDto);
    Map<String, Object>getTotalRatingByFilmId(UUID id);
    Page<PostDetailsDto> getReviewPostsByFilmId(UUID id, Pageable pageable);
    Map<String, Object> getPostByCustomQuery(List<UUID> tags, boolean isReview, boolean latest, boolean popular, int page, int size);
    void deletePostById(UUID id);
}
