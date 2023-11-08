package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.DiscussDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface DiscussService {
    DiscussDto createDiscuss(DiscussDto discussDto);
    List<DiscussDto> getAllDiscussByPostId(UUID postId, boolean reported);
    List<DiscussDto> getAllChildDiscussFromParentDiscussId(UUID discussId, boolean reported);
    DiscussDto updateDiscuus(UUID discussId,DiscussDto discussDto);
    void deleteDiscuss(UUID id);
}
