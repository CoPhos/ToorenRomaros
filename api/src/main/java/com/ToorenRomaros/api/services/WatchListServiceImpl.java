package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.controllers.WatchListController;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.dto.watchList.WatchListDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.watchList.WatchListEntity;
import com.ToorenRomaros.api.exeptions.InvalidRefreshTokenException;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.repositories.watchList.WatchListRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WatchListServiceImpl implements WatchListService{
    private static final Logger log = LoggerFactory.getLogger(WatchListServiceImpl.class);
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;
    private final WatchListRepository watchListRepository;
    private final ModelMapper modelMapper;
    public WatchListServiceImpl(UserRepository userRepository, FilmRepository filmRepository, WatchListRepository watchListRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
        this.watchListRepository = watchListRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public WatchListDto createWatchList(WatchListDto watchListDto) {
        try{
        WatchListEntity watchListEntity = modelMapper.map(watchListDto, WatchListEntity.class);
        UserEntity userEntity = userRepository.findById(UUID.fromString(watchListDto.getUser())).orElseThrow(() -> new UserNotFoundException("'" + watchListDto.getUser() + "'"));
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(watchListDto.getFilm())).orElseThrow(() -> new ResourceNotFoundException("'" + watchListDto.getFilm() + "'"));
        watchListEntity.setUser(userEntity);
        watchListEntity.setFilm(filmEntity);
        return modelMapper.map(watchListRepository.save(watchListEntity), WatchListDto.class);}
        catch (Exception e){
            log.info(e.getMessage());
        }
        return null;
    }

    @Override
    public Page<WatchListDto> getWatchListFromUserByFilmType(UUID id, String filmType, Pageable pageRequest) {
        List<WatchListEntity> allFilms = watchListRepository.findWatchListByUserAndFilmType(String.valueOf(id), filmType, pageRequest);
        assert allFilms != null;
        List<WatchListDto> watchListDtos = allFilms.stream().map(film -> {return modelMapper.map(film, WatchListDto.class);}).collect(Collectors.toList());
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), watchListDtos.size());
        List<WatchListDto> pageContent = watchListDtos.subList(start, end);

        return new PageImpl<>(pageContent, pageRequest, watchListDtos.size());
    }

    @Override
    public void deleteWatchList(UUID id) {
        watchListRepository.findById(id)
                .ifPresentOrElse(watchListRepository::delete, () -> {
                    throw new ResourceNotFoundException("Invalid id.");
                });
    }
}
