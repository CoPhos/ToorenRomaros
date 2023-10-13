package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.genre.GenreFilmDto;
import com.ToorenRomaros.api.dto.streamSite.StreamSiteFilmDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.genre.GenreFilmEntity;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteEntity;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteFilmEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.streamSite.StreamSiteFilmRepository;
import com.ToorenRomaros.api.repositories.streamSite.StreamSiteRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StreamSiteFilmServiceImpl implements StreamSiteFilmService{

    private final StreamSiteFilmRepository streamSiteFilmRepository;
    private final StreamSiteRepository streamSiteRepository;
    private final FilmRepository filmRepository;
    private final ModelMapper modelMapper;

    public StreamSiteFilmServiceImpl(StreamSiteFilmRepository streamSiteFilmRepository, StreamSiteRepository streamSiteRepository, FilmRepository filmRepository, ModelMapper modelMapper) {
        this.streamSiteFilmRepository = streamSiteFilmRepository;
        this.streamSiteRepository = streamSiteRepository;
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public StreamSiteFilmDto createStreamSiteFilm(StreamSiteFilmDto streamSiteFilmDto) {
        StreamSiteFilmEntity streamSiteFilmEntity = modelMapper.map(streamSiteFilmDto, StreamSiteFilmEntity.class);

        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(streamSiteFilmDto.getFilmName())).orElseThrow(() -> new ResourceNotFoundException("'" + streamSiteFilmDto.getFilmName() + "'"));
        StreamSiteEntity streamSiteEntity = streamSiteRepository.findById(UUID.fromString(streamSiteFilmDto.getStreamSiteName())).orElseThrow(() -> new ResourceNotFoundException("'" + streamSiteFilmDto.getStreamSiteName() + "'"));

        streamSiteFilmEntity.setFilm(filmEntity);
        streamSiteFilmEntity.setStreamSite(streamSiteEntity);

        StreamSiteFilmEntity savedStreamSiteFilmEntity = streamSiteFilmRepository.save(streamSiteFilmEntity);
        return modelMapper.map(savedStreamSiteFilmEntity, StreamSiteFilmDto.class);
    }

    @Override
    public List<StreamSiteFilmDto> getStreamSitesByFilmId(UUID id) {
        List<StreamSiteFilmEntity> streamSiteFilmEntities = streamSiteFilmRepository.findAllStreamSitesByFilmId(id.toString());
        if(streamSiteFilmEntities == null){
            throw new ResourceNotFoundException("Resource not found");
        }
        return streamSiteFilmEntities.stream().map(streamSiteFilmEntity -> {
            return modelMapper.map(streamSiteFilmEntity, StreamSiteFilmDto.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public StreamSiteFilmDto updateStreamSiteFilm(UUID id, StreamSiteFilmDto streamSiteFilmDto) {
        StreamSiteFilmEntity streamSiteFilmEntity = modelMapper.map(streamSiteFilmDto, StreamSiteFilmEntity.class);
        StreamSiteFilmEntity newStreamSiteFilmEntity = streamSiteFilmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));

        BeanUtils.copyProperties(streamSiteFilmEntity, newStreamSiteFilmEntity, Utils.getNullPropertyNames(streamSiteFilmEntity));

        if(streamSiteFilmDto.getFilmName() != null){
            FilmEntity filmEntity = filmRepository.findById(UUID.fromString(streamSiteFilmDto.getFilmName())).orElseThrow(() -> new ResourceNotFoundException("'" + streamSiteFilmDto.getFilmName() + "'"));
            streamSiteFilmEntity.setFilm(filmEntity);
        }
        if(streamSiteFilmDto.getStreamSiteName() != null){
            StreamSiteEntity streamSiteEntity = streamSiteRepository.findById(UUID.fromString(streamSiteFilmDto.getStreamSiteName())).orElseThrow(() -> new ResourceNotFoundException("'" + streamSiteFilmDto.getStreamSiteName() + "'"));
            streamSiteFilmEntity.setStreamSite(streamSiteEntity);
        }
        StreamSiteFilmEntity savedStreamSiteFilmEntity = streamSiteFilmRepository.save(newStreamSiteFilmEntity);

        return modelMapper.map(savedStreamSiteFilmEntity, StreamSiteFilmDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public void deleteStreamSiteFilm(UUID id) {
        streamSiteFilmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        streamSiteFilmRepository.deleteById(id);
    }
}
