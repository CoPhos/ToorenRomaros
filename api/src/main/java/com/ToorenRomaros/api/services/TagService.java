package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.tag.CreateTagDto;
import com.ToorenRomaros.api.dto.tag.GetTagDto;

import java.util.UUID;

public interface TagService {
    GetTagDto createTag(CreateTagDto createTagDto);
    GetTagDto updateTag(UUID id, CreateTagDto createTagDto);
    void deleteTag(UUID uuid);
}
