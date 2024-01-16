package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.watchList.WatchListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface WatchListService {
    WatchListDto createWatchList(WatchListDto watchListDto);
    Page<WatchListDto> getWatchListFromUserByFilmType(UUID id, String filmType, Pageable pageRequest);
    void deleteWatchList(UUID id);
}
