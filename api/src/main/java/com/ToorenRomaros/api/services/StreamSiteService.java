package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.streamSite.CreateStreamSiteDto;
import com.ToorenRomaros.api.dto.streamSite.GetStreamSiteDto;
import com.ToorenRomaros.api.dto.streamSite.UpdateStreamSiteDto;

import java.util.UUID;

public interface StreamSiteService {
    GetStreamSiteDto createStreamSite(CreateStreamSiteDto createStreamSiteDto);
    GetStreamSiteDto getStreamSite(UUID id);
    GetStreamSiteDto updateStreamSite(UUID id, UpdateStreamSiteDto createStreamSiteDto);
    void deleteStreamSite(UUID id);
}
