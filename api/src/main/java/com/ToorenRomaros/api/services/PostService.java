package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById(UUID id);
    List<PostDto> getLatestPostsTittleAndHeadline();
    PostDto updatePostById(UUID id, PostDto postDto);
    void deletePostById(UUID id);
}
