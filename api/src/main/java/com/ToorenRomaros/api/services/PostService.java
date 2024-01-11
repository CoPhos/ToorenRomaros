package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.PostDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById(UUID id);
    PostDto updatePostById(UUID id, PostDto postDto);
    Map<String, Object> getPostByCustomQuery(List<String> attributes, List<UUID> tags, boolean latest, boolean popular, int page, int size);
    void deletePostById(UUID id);
}
