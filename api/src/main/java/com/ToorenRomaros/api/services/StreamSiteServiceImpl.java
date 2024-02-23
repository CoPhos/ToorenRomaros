package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.streamSite.CreateStreamSiteDto;
import com.ToorenRomaros.api.dto.streamSite.GetStreamSiteDto;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteEntity;
import com.ToorenRomaros.api.dto.streamSite.UpdateStreamSiteDto;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.streamSite.StreamSiteRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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
    @Override
    public GetStreamSiteDto createStreamSite(CreateStreamSiteDto createStreamSiteDto) {
        StreamSiteEntity streamSiteEntity = modelMapper.map(createStreamSiteDto, StreamSiteEntity.class);
        StreamSiteEntity savedStreamSite = streamSiteRepository.save(streamSiteEntity);
        return modelMapper.map(savedStreamSite, GetStreamSiteDto.class);
    }
    @Override
    public GetStreamSiteDto getStreamSite(UUID id) {
        StreamSiteEntity streamSiteEntity = streamSiteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stream site not found."));
        return modelMapper.map(streamSiteEntity, GetStreamSiteDto.class);
    }
    @Override
    public GetStreamSiteDto updateStreamSite(UUID id, UpdateStreamSiteDto createStreamSiteDto) {
        StreamSiteEntity streamSiteEntity = modelMapper.map(createStreamSiteDto, StreamSiteEntity.class);
        StreamSiteEntity newStreamSiteEntity = streamSiteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stream site not found."));
        BeanUtils.copyProperties(streamSiteEntity, newStreamSiteEntity, Utils.getNullPropertyNames(streamSiteEntity));
        return modelMapper.map(newStreamSiteEntity, GetStreamSiteDto.class);
    }
    @Override
    public void deleteStreamSite(UUID id) {
        streamSiteRepository.findById(id)
                .ifPresentOrElse(streamSiteRepository::delete, () -> {
                    throw new ResourceNotFoundException("Stream site not found.");
                });
    }
}
