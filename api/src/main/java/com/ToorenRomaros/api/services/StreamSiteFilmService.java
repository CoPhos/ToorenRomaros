package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.streamSite.CreateStreamSiteFilmDto;
import com.ToorenRomaros.api.dto.streamSite.GetStreamSiteFilmDto;

import java.util.List;
import java.util.UUID;

public interface StreamSiteFilmService {
    GetStreamSiteFilmDto createStreamSiteFilm(CreateStreamSiteFilmDto createStreamSiteFilmDto);
    List<GetStreamSiteFilmDto> getStreamSitesByFilmId(UUID uuid);
    void deleteStreamSiteFilm(UUID id);
}
