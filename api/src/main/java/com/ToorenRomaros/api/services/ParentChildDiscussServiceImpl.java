package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.ParentChildDiscussDto;
import com.ToorenRomaros.api.entities.publication.DiscussEntity;
import com.ToorenRomaros.api.entities.publication.ParentChildDiscussEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.publication.DiscussRepository;
import com.ToorenRomaros.api.repositories.publication.ParentChildDiscussRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParentChildDiscussServiceImpl implements ParentChildDiscussService{

    private final ModelMapper modelMapper;
    private final DiscussRepository discussRepository;
    private final ParentChildDiscussRepository parentChildDiscussRepository;

    public ParentChildDiscussServiceImpl(ModelMapper modelMapper, DiscussRepository discussRepository, ParentChildDiscussRepository parentChildDiscussRepository) {
        this.modelMapper = modelMapper;
        this.discussRepository = discussRepository;
        this.parentChildDiscussRepository = parentChildDiscussRepository;
    }

    @Override
    public ParentChildDiscussDto createSubDiscuss(ParentChildDiscussDto parentChildDiscussDto) {
        ParentChildDiscussEntity parentChildDiscussEntity = new ParentChildDiscussEntity();
        DiscussEntity parentDiscuss = discussRepository.findById(UUID.fromString(parentChildDiscussDto.getParentId())).orElseThrow(() -> new ResourceNotFoundException("Discuss: " + parentChildDiscussDto.getParentId() +  " not found"));
        DiscussEntity childDiscuss = discussRepository.findById(UUID.fromString(parentChildDiscussDto.getChildId())).orElseThrow(() -> new ResourceNotFoundException("Discuss: " + parentChildDiscussDto.getChildId() +  " not found"));

        parentChildDiscussEntity.setParent(parentDiscuss);
        parentChildDiscussEntity.setChild(childDiscuss);

        ParentChildDiscussEntity savedParentChildDiscussEntity = parentChildDiscussRepository.save(parentChildDiscussEntity);

        return modelMapper.map(savedParentChildDiscussEntity, ParentChildDiscussDto.class);
    }
}
