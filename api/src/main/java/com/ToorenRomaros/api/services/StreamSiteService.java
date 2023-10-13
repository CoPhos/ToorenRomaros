package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.streamSite.StreamSiteDto;

import java.util.UUID;

public interface StreamSiteService {
    StreamSiteDto createStreamSite(StreamSiteDto streamSiteDto);
    StreamSiteDto getStreamSite(UUID id);
    StreamSiteDto updateStreamSite(UUID id, StreamSiteDto streamSiteDto);
    void deleteStreamSite(UUID id);
}
