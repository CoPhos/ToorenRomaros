package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.watchList.WatchListDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.watchList.WatchListEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.repositories.watchList.WatchListRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WatchListServiceImpl implements WatchListService {
    private static final Logger log = LoggerFactory.getLogger(WatchListServiceImpl.class);
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;
    private final WatchListRepository watchListRepository;
    private final ImageRepostiroy imageRepostiroy;
    private final ModelMapper modelMapper;

    public WatchListServiceImpl(UserRepository userRepository, FilmRepository filmRepository, WatchListRepository watchListRepository, ImageRepostiroy imageRepostiroy, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
        this.watchListRepository = watchListRepository;
        this.imageRepostiroy = imageRepostiroy;
        this.modelMapper = modelMapper;
    }

    @Override
    public WatchListDto createWatchList(WatchListDto watchListDto) {

        WatchListEntity watchListEntity = modelMapper.map(watchListDto, WatchListEntity.class);
        UserEntity userEntity = userRepository.findById(UUID.fromString(watchListDto.getUser())).orElseThrow(() -> new UserNotFoundException("'" + watchListDto.getUser() + "'"));
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(watchListDto.getFilm())).orElseThrow(() -> new ResourceNotFoundException("'" + watchListDto.getFilm() + "'"));
        watchListEntity.setUser(userEntity);
        watchListEntity.setFilm(filmEntity);
        return modelMapper.map(watchListRepository.save(watchListEntity), WatchListDto.class);

    }

    @Override
    public Page<WatchListDto> getWatchListFromUserByFilmType(UUID id, String filmType, Pageable pageRequest) {
        try{
            Page<WatchListEntity> allFilms = watchListRepository.findWatchListByUserAndFilmType(id,pageRequest);
            return allFilms.map(watchListEntity -> {
                List<ImageEntity> imageEntities = imageRepostiroy.findAllImageByImageType("FILM_MAIN", watchListEntity.getFilm().getId().toString());
                WatchListDto watchListDto = modelMapper.map(watchListEntity, WatchListDto.class);
                if (watchListEntity.getFilm().getFilmType() == 1) {
                    Movie movie = (Movie) watchListEntity.getFilm();
                    watchListDto.setTheatersReleaseDate(movie.getTheatersReleaseDate());
                }
                if (!imageEntities.isEmpty()) {
                    watchListDto.setMainImageId(imageEntities.get(0).getId().toString());
                }
                return watchListDto;
            });
        }catch (Exception e){
            log.info(e.getMessage());
            log.info(String.valueOf(e.getCause()));
        }
        return null;
    }

    @Override
    public void deleteFromWatchListByUserIdAndFilmId(UUID userId, UUID filmId) {
        watchListRepository.findByUserAndFilm(userId.toString(), filmId.toString())
                .ifPresentOrElse(watchListRepository::delete, () -> {
                    throw new ResourceNotFoundException("Invalid ids.");
                });
    }
}
