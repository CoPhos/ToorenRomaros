package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.streamSite.StreamSiteFilmDto;

import java.util.List;
import java.util.UUID;

public interface StreamSiteFilmService {
    StreamSiteFilmDto createStreamSiteFilm(StreamSiteFilmDto streamSiteFilmDto);
    List<StreamSiteFilmDto> getStreamSitesByFilmId(UUID uuid);
    StreamSiteFilmDto updateStreamSiteFilm(UUID id, StreamSiteFilmDto streamSiteFilmDto);
    void deleteStreamSiteFilm(UUID id);
}
