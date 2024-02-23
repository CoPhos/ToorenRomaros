package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.watchList.CreateWatchListDto;
import com.ToorenRomaros.api.dto.watchList.GetWatchListDto;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WatchListServiceImpl implements WatchListService {
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
    public GetWatchListDto createWatchList(CreateWatchListDto createWatchListDto) {
        WatchListEntity watchListEntity = modelMapper.map(createWatchListDto, WatchListEntity.class);
        UserEntity userEntity = userRepository.findById(UUID.fromString(createWatchListDto.getUser())).orElseThrow(() -> new UserNotFoundException("User not found."));
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(createWatchListDto.getFilm())).orElseThrow(() -> new ResourceNotFoundException("Film not found."));
        watchListEntity.setUser(userEntity);
        watchListEntity.setFilm(filmEntity);
        return modelMapper.map(watchListRepository.save(watchListEntity), GetWatchListDto.class);
    }
    @Override
    public Page<GetWatchListDto> getWatchListFromUserByFilmType(UUID id, String filmType, Pageable pageRequest) {
        Page<WatchListEntity> allFilms = watchListRepository.findWatchListByUserAndFilmType(id, pageRequest);
        return allFilms.map(watchListEntity -> {
            List<ImageEntity> imageEntities = imageRepostiroy.findAllImageByImageType("FILM_MAIN", watchListEntity.getFilm().getId().toString());
            GetWatchListDto createWatchListDto = modelMapper.map(watchListEntity, GetWatchListDto.class);
            if (watchListEntity.getFilm().getFilmType() == 1) {
                Movie movie = (Movie) watchListEntity.getFilm();
                createWatchListDto.setTheatersReleaseDate(movie.getTheatersReleaseDate());
            }
            if (!imageEntities.isEmpty()) {
                createWatchListDto.setMainImageId(imageEntities.get(0).getId().toString());
            }
            return createWatchListDto;
        });
    }
    @Override
    public void deleteFromWatchListByUserIdAndFilmId(UUID userId, UUID filmId) {
        watchListRepository.findByUserAndFilm(userId.toString(), filmId.toString())
                .ifPresentOrElse(watchListRepository::delete, () -> {
                    throw new ResourceNotFoundException("Watchlist item not found.");
                });
    }
}
