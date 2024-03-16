package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.CreateLikeDto;

import java.util.UUID;

public interface LikeService {
    void addLike(CreateLikeDto createLikeDto);
    void removeLike(UUID ownerId, UUID userId);
}
