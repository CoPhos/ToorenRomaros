package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.CreateLikeDto;
import com.ToorenRomaros.api.dto.publication.DeleteLikeDto;

import java.util.UUID;

public interface LikeService {
    void addLike(CreateLikeDto createLikeDto);
    void removeLike(DeleteLikeDto deleteLikeDto);
}
