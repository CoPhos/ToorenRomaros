package com.ToorenRomaros.api.config;

import com.ToorenRomaros.api.dto.film.*;
import com.ToorenRomaros.api.dto.genre.GetGenreFilmDto;
import com.ToorenRomaros.api.dto.media.GetListImagesDto;
import com.ToorenRomaros.api.dto.publication.*;
import com.ToorenRomaros.api.dto.staff.GetStaffFilmDto;
import com.ToorenRomaros.api.dto.streamSite.GetStreamSiteFilmDto;
import com.ToorenRomaros.api.dto.user.RefreshTokenDto;
import com.ToorenRomaros.api.dto.watchList.CreateWatchListDto;
import com.ToorenRomaros.api.dto.watchList.GetWatchListDto;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.entities.genre.GenreFilmEntity;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.entities.publication.*;
import com.ToorenRomaros.api.entities.staff.StaffFilmEntity;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteFilmEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.watchList.WatchListEntity;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        //Film
        TypeMap<Movie, CreateMovieDto> propertyMapperCreateMovieSaga = modelMapper.createTypeMap(Movie.class, CreateMovieDto.class);
        propertyMapperCreateMovieSaga.addMappings(
                mapper -> {
                    mapper.map(src -> src.getSaga().getName(), CreateMovieDto::setSagaId);
                }
        );
        TypeMap<Serie, CreateSerieDto> propertyMapperCreateSerieSaga = modelMapper.createTypeMap(Serie.class, CreateSerieDto.class);
        propertyMapperCreateSerieSaga.addMappings(
                mapper -> {
                    mapper.map(src -> src.getSaga().getName(), CreateSerieDto::setSagaId);
                }
        );
        TypeMap<Movie, GetMovieDto> propertyMapperGetMovieSaga = modelMapper.createTypeMap(Movie.class, GetMovieDto.class);
        propertyMapperGetMovieSaga.addMappings(
                mapper -> {
                    mapper.map(src -> src.getSaga().getName(), GetMovieDto::setSagaId);
                }
        );
        TypeMap<Serie, GetSerieDto> propertyMapperGetSerieSaga = modelMapper.createTypeMap(Serie.class, GetSerieDto.class);
        propertyMapperGetSerieSaga.addMappings(
                mapper -> {
                    mapper.map(src -> src.getSaga().getName(), GetSerieDto::setSagaId);
                }
        );
        TypeMap<Movie, UpdateMovieDto> propertyMapperUpdateMovieSaga = modelMapper.createTypeMap(Movie.class, UpdateMovieDto.class);
        propertyMapperUpdateMovieSaga.addMappings(
                mapper -> {
                    mapper.map(src -> src.getSaga().getName(), UpdateMovieDto::setSagaId);
                }
        );
        TypeMap<Serie, UpdateSerieDto> propertyMapperUpdateSerieSaga = modelMapper.createTypeMap(Serie.class, UpdateSerieDto.class);
        propertyMapperUpdateSerieSaga.addMappings(
                mapper -> {
                    mapper.map(src -> src.getSaga().getName(), UpdateSerieDto::setSagaId);
                }
        );

        //StaffFilm
        TypeMap<StaffFilmEntity, GetStaffFilmDto> propertyMapperStaffFilmDto = modelMapper.createTypeMap(StaffFilmEntity.class, GetStaffFilmDto.class);
        propertyMapperStaffFilmDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getTittle(), GetStaffFilmDto::setFilmName);
                    mapper.map(src -> src.getStaff().getFullName(), GetStaffFilmDto::setStaffName);
                    mapper.map(src -> src.getStaff().getId(), GetStaffFilmDto::setStaffId);
                }
        );

        //GenreFilm
        TypeMap<GenreFilmEntity, GetGenreFilmDto> propertyMapperGenreFilmDto = modelMapper.createTypeMap(GenreFilmEntity.class, GetGenreFilmDto.class);
        propertyMapperGenreFilmDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getTittle(), GetGenreFilmDto::setFilm);
                    mapper.map(src -> src.getGenre().getGenre(), GetGenreFilmDto::setGenre);
                }
        );

        //StreamSiteFilm
        TypeMap<StreamSiteFilmEntity, GetStreamSiteFilmDto> propertyMapperStreamSiteFilmDto = modelMapper.createTypeMap(StreamSiteFilmEntity.class, GetStreamSiteFilmDto.class);
        propertyMapperStreamSiteFilmDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getTittle(), GetStreamSiteFilmDto::setFilmName);
                    mapper.map(src -> src.getStreamSite().getName(), GetStreamSiteFilmDto::setStreamSiteName);
                    mapper.map(src -> src.getStreamSite().getId(), GetStreamSiteFilmDto::setStreamsiteId);
                }
        );

        //Comment
        TypeMap<CommentEntity, GetCommentDto> propertyMapperCommentDto = modelMapper.createTypeMap(CommentEntity.class, GetCommentDto.class);
        propertyMapperCommentDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getId(), GetCommentDto::setFilmId);
                    mapper.map(src -> src.getUser().getId(), GetCommentDto::setUserId);
                    mapper.map(src -> src.getUser().getUsername(), GetCommentDto::setUsername);
                }
        );

        TypeMap<PostEntity, GetPostDetailsDto> propertyMapperPostDetailsDto = modelMapper.createTypeMap(PostEntity.class, GetPostDetailsDto.class);
        propertyMapperPostDetailsDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getUser().getUsername(), GetPostDetailsDto::setUser);
                    mapper.map(src -> src.getFilm().getId(), GetPostDetailsDto::setFilmId);
                    mapper.map(src -> src.getTag().getTag(), GetPostDetailsDto::setTag);
                }
        );
        //PostDto
        TypeMap<PostEntity, GetPostDto> propertyMapperPostDto = modelMapper.createTypeMap(PostEntity.class, GetPostDto.class);
        propertyMapperPostDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getUser().getId(), GetPostDto::setUser);
                    mapper.map(src -> src.getTag().getTag(), GetPostDto::setTag);
                    mapper.map(src -> src.getFilm().getId(), GetPostDto::setFilm);
                    mapper.map(src -> src.getTag().getId(), GetPostDto::setTagId);
                }
        );

        //UserToken
        TypeMap<UserEntity, RefreshTokenDto> propertyMapperRefreshTokenDto = modelMapper.createTypeMap(UserEntity.class, RefreshTokenDto.class);
        propertyMapperRefreshTokenDto.addMappings(
                mapper -> {
                    mapper.map(UserEntity::getId, RefreshTokenDto::setUser);
                }
        );

        //Watchlist
        TypeMap<WatchListEntity, GetWatchListDto> propertyMapperWatchListDto = modelMapper.createTypeMap(WatchListEntity.class, GetWatchListDto.class);
        propertyMapperWatchListDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getId(), GetWatchListDto::setFilm);
                    mapper.map(src -> src.getUser().getId(), GetWatchListDto::setUser);
                    mapper.map(src -> src.getFilm().getAverageSuperRating(), GetWatchListDto::setAverageSuperRating);
                    mapper.map(src -> src.getFilm().getAverageUserRating(), GetWatchListDto::setAverageUserRating);
                    mapper.map(src -> src.getFilm().getTittle(), GetWatchListDto::setTittle);

                }
        );

        //ImageEntity
        TypeMap<ImageEntity, GetListImagesDto> propertyMapperGetListImagesDto = modelMapper.createTypeMap(ImageEntity.class, GetListImagesDto.class);
        propertyMapperGetListImagesDto.addMappings(
                mapper -> {
                    mapper.map(src -> {
                        try {
                            return src.getOwnerId();
                        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }, GetListImagesDto::setOwner);
                }
        );

        return modelMapper;
    }
}
