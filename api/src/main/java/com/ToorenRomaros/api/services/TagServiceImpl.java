package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.tag.TagDto;
import com.ToorenRomaros.api.entities.tag.TagEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.tag.TagRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;
    public TagServiceImpl(TagRepository tagRepository, ModelMapper modelMapper) {
        this.tagRepository = tagRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TagDto createTag(TagDto tagDto) {
        TagEntity tagEntity = modelMapper.map(tagDto, TagEntity.class);
        return modelMapper.map(tagRepository.save(tagEntity), TagDto.class);
    }

    @Override
    public TagDto updateTag(UUID id, TagDto tagDto) {
        TagEntity tagEntity = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        BeanUtils.copyProperties(tagDto, tagEntity, Utils.getNullPropertyNames(tagDto));
        return modelMapper.map(tagRepository.save(tagEntity), TagDto.class);
    }

    @Override
    public void deleteTag(UUID uuid) {
        tagRepository.findById(uuid)
                .ifPresentOrElse(tagRepository::delete, () -> {
                    throw new ResourceNotFoundException("'" + uuid + "'");
                });
    }
}
