package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.EpisodeDto;
import com.ToorenRomaros.api.entities.film.EpisodeEntity;

import java.util.List;
import java.util.UUID;

public interface EpisodeService {
    EpisodeDto createEpisode(EpisodeDto episodeDto);
    EpisodeDto getEpisodeById(UUID id);
    List<EpisodeDto> getAllEpisodesBySerieId(UUID id);
    EpisodeDto updateEpisode(UUID id, EpisodeDto episodeDto);
    void deleteEpisode(UUID id);
}
