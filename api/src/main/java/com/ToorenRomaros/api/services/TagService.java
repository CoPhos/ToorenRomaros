package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.tag.TagDto;

import java.util.UUID;

public interface TagService {
    TagDto createTag(TagDto tagDto);
    TagDto updateTag(UUID id, TagDto tagDto);
    void deleteTag(UUID uuid);
}
