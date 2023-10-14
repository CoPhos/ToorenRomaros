package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.EpisodeDto;
import com.ToorenRomaros.api.dto.streamSite.StreamSiteFilmDto;
import com.ToorenRomaros.api.entities.film.EpisodeEntity;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteFilmEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.EpisodeRepository;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EpisodeServiceImpl implements EpisodeService{
    private final ModelMapper modelMapper;
    private final EpisodeRepository episodeRepository;
    private final FilmRepository filmRepository;
    public EpisodeServiceImpl(ModelMapper modelMapper, EpisodeRepository episodeRepository, FilmRepository filmRepository) {
        this.modelMapper = modelMapper;
        this.episodeRepository = episodeRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public EpisodeDto createEpisode(EpisodeDto episodeDto) {
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(episodeDto.getSerieId())).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        EpisodeEntity episodeEntity = modelMapper.map(episodeDto, EpisodeEntity.class);

        episodeEntity.setSerie((Serie) filmEntity);
        EpisodeEntity savedEpisode = episodeRepository.save(episodeEntity);
        return modelMapper.map(savedEpisode, EpisodeDto.class);
    }

    @Override
    public EpisodeDto getEpisodeById(UUID id) {
        EpisodeEntity episodeEntity = episodeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return modelMapper.map(episodeEntity, EpisodeDto.class);
    }

    @Override
    public List<EpisodeDto> getAllEpisodesBySerieId(UUID id) {
        List<EpisodeEntity> episodeEntities = episodeRepository.findAllEpisodesBYSerieId(id.toString());
        if(episodeEntities == null){
            throw new ResourceNotFoundException("Resource not found");
        }
        return episodeEntities.stream().map(episodeEntity -> {
            return modelMapper.map(episodeEntity, EpisodeDto.class);
        }).collect(Collectors.toList());
    }

    @Override
    public EpisodeDto updateEpisode(UUID id, EpisodeDto episodeDto) {
        EpisodeEntity episodeEntity = modelMapper.map(episodeDto, EpisodeEntity.class);
        EpisodeEntity newEpisode = episodeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));

        BeanUtils.copyProperties(episodeEntity, newEpisode, Utils.getNullPropertyNames(episodeEntity));

        if(episodeDto.getSerieId() != null){
            FilmEntity filmEntity = filmRepository.findById(UUID.fromString(episodeDto.getSerieId())).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
            episodeEntity.setSerie((Serie) filmEntity);
        }

        EpisodeEntity savedEpisode = episodeRepository.save(newEpisode);
        return modelMapper.map(savedEpisode, EpisodeDto.class);
    }

    @Override
    public void deleteEpisode(UUID id) {
        episodeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        episodeRepository.deleteById(id);
    }
}
