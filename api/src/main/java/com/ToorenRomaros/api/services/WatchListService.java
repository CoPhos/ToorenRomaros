package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.watchList.CreateWatchListDto;
import com.ToorenRomaros.api.dto.watchList.GetWatchListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface WatchListService {
    GetWatchListDto createWatchList(CreateWatchListDto createWatchListDto);
    Page<GetWatchListDto> getWatchListFromUserByFilmType(UUID id, String filmType, Pageable pageRequest);
    void deleteFromWatchListByUserIdAndFilmId(UUID userId, UUID filmiId);
}
