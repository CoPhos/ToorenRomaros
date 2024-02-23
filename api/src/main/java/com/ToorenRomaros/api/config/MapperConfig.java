package com.ToorenRomaros.api.config;

import com.ToorenRomaros.api.dto.film.CreateMovieDto;
import com.ToorenRomaros.api.dto.film.CreateSerieDto;
import com.ToorenRomaros.api.dto.film.UpdateMovieDto;
import com.ToorenRomaros.api.dto.film.UpdateSerieDto;
import com.ToorenRomaros.api.dto.genre.CreateGenreFilmDto;
import com.ToorenRomaros.api.dto.genre.GetGenreFilmDto;
import com.ToorenRomaros.api.dto.media.GetListImagesDto;
import com.ToorenRomaros.api.dto.publication.*;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;
import com.ToorenRomaros.api.dto.staff.StaffFilmDto;
import com.ToorenRomaros.api.dto.streamSite.StreamSiteFilmDto;
import com.ToorenRomaros.api.dto.user.RefreshTokenDto;
import com.ToorenRomaros.api.dto.watchList.WatchListDto;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.entities.genre.GenreFilmEntity;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.entities.publication.*;
import com.ToorenRomaros.api.entities.socials.SocialStaffEntity;
import com.ToorenRomaros.api.entities.socials.SocialUserEntity;
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

        //Social
        TypeMap<SocialStaffEntity, SocialGenericDto> propertyMapperSocialStaffToDto = modelMapper.createTypeMap(SocialStaffEntity.class, SocialGenericDto.class);
        propertyMapperSocialStaffToDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getStaff().getFirstName(), SocialGenericDto::setGenericName);
                    mapper.map(src -> src.getSocial().getName(), SocialGenericDto::setSocialName);
                }
        );

        //socialUser
        TypeMap<SocialUserEntity, SocialGenericDto> propertyMapperSocialUseroDto = modelMapper.createTypeMap(SocialUserEntity.class, SocialGenericDto.class);
        propertyMapperSocialUseroDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getUser().getUsername(), SocialGenericDto::setGenericName);
                    mapper.map(src -> src.getSocial().getName(), SocialGenericDto::setSocialName);
                }
        );

        //StaffFilm
        TypeMap<StaffFilmEntity, StaffFilmDto> propertyMapperStaffFilmDto = modelMapper.createTypeMap(StaffFilmEntity.class, StaffFilmDto.class);
        propertyMapperStaffFilmDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getTittle(), StaffFilmDto::setFilmName);
                    mapper.map(src -> src.getStaff().getFullName(), StaffFilmDto::setStaffName);
                    mapper.map(src -> src.getStaff().getId(), StaffFilmDto::setStaffId);
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
        TypeMap<StreamSiteFilmEntity, StreamSiteFilmDto> propertyMapperStreamSiteFilmDto = modelMapper.createTypeMap(StreamSiteFilmEntity.class, StreamSiteFilmDto.class);
        propertyMapperStreamSiteFilmDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getTittle(), StreamSiteFilmDto::setFilmName);
                    mapper.map(src -> src.getStreamSite().getName(), StreamSiteFilmDto::setStreamSiteName);
                    mapper.map(src -> src.getStreamSite().getId(), StreamSiteFilmDto::setStreamsiteId);
                }
        );

        //Comment
        TypeMap<CommentEntity, CommentDto> propertyMapperCommentDto = modelMapper.createTypeMap(CommentEntity.class, CommentDto.class);
        propertyMapperCommentDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getId(), CommentDto::setFilmId);
                    mapper.map(src -> src.getUser().getId(), CommentDto::setUserId);
                    mapper.map(src -> src.getUser().getUsername(), CommentDto::setUsername);
                }
        );

        TypeMap<PostEntity, PostDetailsDto> propertyMapperPostDetailsDto = modelMapper.createTypeMap(PostEntity.class, PostDetailsDto.class);
        propertyMapperPostDetailsDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getUser().getUsername(), PostDetailsDto::setUser);
                    mapper.map(src -> src.getFilm().getId(), PostDetailsDto::setFilmId);
                    mapper.map(src -> src.getTag().getTag(), PostDetailsDto::setTag);
                }
        );


        //Discuss
        TypeMap<DiscussEntity, DiscussDto> propertyMapperDiscussDto = modelMapper.createTypeMap(DiscussEntity.class, DiscussDto.class);
        propertyMapperDiscussDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getPost().getId(), DiscussDto::setPostId);
                    mapper.map(src -> src.getUser().getId(), DiscussDto::setUserId);
                }
        );

        //ParentChild
        TypeMap<ParentChildDiscussEntity, ParentChildDiscussDto> propertyMapperParentChildDto = modelMapper.createTypeMap(ParentChildDiscussEntity.class, ParentChildDiscussDto.class);
        propertyMapperParentChildDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getParent().getId(), ParentChildDiscussDto::setParentId);
                    mapper.map(src -> src.getChild().getId(), ParentChildDiscussDto::setChildId);
                }
        );

        //PostDto
        TypeMap<PostEntity, PostDto> propertyMapperPostDto = modelMapper.createTypeMap(PostEntity.class, PostDto.class);
        propertyMapperPostDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getUser().getId(), PostDto::setUser);
                    mapper.map(src -> src.getTag().getTag(), PostDto::setTag);
                    mapper.map(src -> src.getFilm().getId(), PostDto::setFilm);
                    mapper.map(src -> src.getTag().getId(), PostDto::setTagId);
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
        TypeMap<WatchListEntity, WatchListDto> propertyMapperWatchListDto = modelMapper.createTypeMap(WatchListEntity.class, WatchListDto.class);
        propertyMapperWatchListDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getId(), WatchListDto::setFilm);
                    mapper.map(src -> src.getUser().getId(), WatchListDto::setUser);
                    mapper.map(src -> src.getFilm().getAverageSuperRating(), WatchListDto::setAverageSuperRating);
                    mapper.map(src -> src.getFilm().getAverageUserRating(), WatchListDto::setAverageUserRating);
                    mapper.map(src -> src.getFilm().getTittle(), WatchListDto::setTittle);

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
