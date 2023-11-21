package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.PostDto;

import java.util.UUID;

public interface PostService {
    PostDto createPost(PostDto postDto);
    void deletePostById(UUID id);
}
