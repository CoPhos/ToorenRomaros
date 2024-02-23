package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.tag.CreateTagDto;
import com.ToorenRomaros.api.dto.tag.GetTagDto;
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
    public GetTagDto createTag(CreateTagDto createTagDto) {
        TagEntity tagEntity = modelMapper.map(createTagDto, TagEntity.class);
        return modelMapper.map(tagRepository.save(tagEntity), GetTagDto.class);
    }

    @Override
    public GetTagDto updateTag(UUID id, CreateTagDto createTagDto) {
        TagEntity tagEntity = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag not found"));
        BeanUtils.copyProperties(createTagDto, tagEntity, Utils.getNullPropertyNames(createTagDto));
        return modelMapper.map(tagRepository.save(tagEntity), GetTagDto.class);
    }

    @Override
    public void deleteTag(UUID uuid) {
        tagRepository.findById(uuid)
                .ifPresentOrElse(tagRepository::delete, () -> {
                    throw new ResourceNotFoundException("'" + uuid + "'");
                });
    }
}
