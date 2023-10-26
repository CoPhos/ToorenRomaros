package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.streamSite.StreamSiteFilmEntity;

import java.util.List;
import java.util.UUID;

public interface FilmRepositoryCustom {
    List<StreamSiteFilmEntity> findFilmByNameAndDuration(String streamSiteId, List<UUID> genres, String suitableFor, String filmType, boolean atTheaters, boolean commingSoon, boolean atStreaming);
}
