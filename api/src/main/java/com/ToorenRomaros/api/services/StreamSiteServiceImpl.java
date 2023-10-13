package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.streamSite.StreamSiteDto;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.streamSite.StreamSiteRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StreamSiteServiceImpl implements StreamSiteService{
    private final StreamSiteRepository streamSiteRepository;
    private final ModelMapper modelMapper;

    public StreamSiteServiceImpl(StreamSiteRepository streamSiteRepository, ModelMapper modelMapper) {
        this.streamSiteRepository = streamSiteRepository;
        this.modelMapper = modelMapper;
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public StreamSiteDto createStreamSite(StreamSiteDto streamSiteDto) {
        StreamSiteEntity streamSiteEntity = modelMapper.map(streamSiteDto, StreamSiteEntity.class);
        StreamSiteEntity savedStreamSite = streamSiteRepository.save(streamSiteEntity);
        return modelMapper.map(savedStreamSite, StreamSiteDto.class);
    }
    @Override
    public StreamSiteDto getStreamSite(UUID id) {
        StreamSiteEntity streamSiteEntity = streamSiteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        return modelMapper.map(streamSiteEntity, StreamSiteDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public StreamSiteDto updateStreamSite(UUID id, StreamSiteDto streamSiteDto) {
        StreamSiteEntity streamSiteEntity = modelMapper.map(streamSiteDto, StreamSiteEntity.class);
        StreamSiteEntity newStreamSiteEntity = streamSiteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));

        BeanUtils.copyProperties(streamSiteEntity, newStreamSiteEntity, Utils.getNullPropertyNames(streamSiteEntity));

        return modelMapper.map(newStreamSiteEntity, StreamSiteDto.class);
    }@PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public void deleteStreamSite(UUID id) {
        streamSiteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        streamSiteRepository.deleteById(id);
    }
}
