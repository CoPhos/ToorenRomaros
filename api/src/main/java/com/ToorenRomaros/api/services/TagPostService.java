package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.tag.TagDto;
import com.ToorenRomaros.api.dto.tag.TagPostDto;

import java.util.UUID;

public interface TagPostService {
    TagPostDto createTagPost(TagPostDto tagPostDto);
    TagPostDto updateTagPost(UUID id, TagPostDto tagPostDto);
    void deleteTagPost(UUID uuid);
}
