package com.ToorenRomaros.api.config;

import com.ToorenRomaros.api.dto.film.EpisodeDto;
import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.SerieDto;
import com.ToorenRomaros.api.dto.genre.GenreFilmDto;
import com.ToorenRomaros.api.dto.publication.*;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;
import com.ToorenRomaros.api.dto.staff.StaffFilmDto;
import com.ToorenRomaros.api.dto.streamSite.StreamSiteFilmDto;
import com.ToorenRomaros.api.dto.user.RefreshTokenDto;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.entities.film.EpisodeEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.entities.genre.GenreFilmEntity;
import com.ToorenRomaros.api.entities.publication.*;
import com.ToorenRomaros.api.entities.socials.SocialEntity;
import com.ToorenRomaros.api.entities.socials.SocialStaffEntity;
import com.ToorenRomaros.api.entities.socials.SocialUserEntity;
import com.ToorenRomaros.api.entities.staff.StaffFilmEntity;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteFilmEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        //User
        TypeMap<UserFollowerEntity, UserFollowerDto> propertyMapperFollower = modelMapper.createTypeMap(UserFollowerEntity.class, UserFollowerDto.class);
        propertyMapperFollower.addMappings(
                mapper -> {
                    mapper.map(src -> src.getUser().getUsername(), UserFollowerDto::setUser);
                    mapper.map(src -> src.getFollower().getUsername(), UserFollowerDto::setFollower);
                    mapper.map(UserFollowerEntity::getFollowDate, UserFollowerDto::setFollowDate);
                }
        );

        //Film
        TypeMap<Movie, MovieDto> propertyMapperMoviePrequelSequel = modelMapper.createTypeMap(Movie.class, MovieDto.class);
        propertyMapperMoviePrequelSequel.addMappings(
                mapper -> {
                    mapper.map(src -> src.getPrequel().getTittle(), MovieDto::setPrequel);
                    mapper.map(src -> src.getSequel().getTittle(), MovieDto::setSequel);
                    mapper.map(src -> src.getSaga().getName(), MovieDto::setSagaId);
                }
        );
        TypeMap<Serie, SerieDto> propertyMapperSeriePrequelSequel = modelMapper.createTypeMap(Serie.class, SerieDto.class);
        propertyMapperSeriePrequelSequel.addMappings(
                mapper -> {
                    mapper.map(src -> src.getPrequel().getTittle(), SerieDto::setPrequel);
                    mapper.map(src -> src.getSequel().getTittle(), SerieDto::setSequel);
                    mapper.map(src -> src.getSaga().getName(), SerieDto::setSagaId);
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
                }
        );

        //GenreFilm
        TypeMap<GenreFilmEntity, GenreFilmDto> propertyMapperGenreFilmDto = modelMapper.createTypeMap(GenreFilmEntity.class, GenreFilmDto.class);
        propertyMapperGenreFilmDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getTittle(), GenreFilmDto::setFilm);
                    mapper.map(src -> src.getGenre().getGenre(), GenreFilmDto::setGenre);
                }
        );

        //StreamSiteFilm
        TypeMap<StreamSiteFilmEntity, StreamSiteFilmDto> propertyMapperStreamSiteFilmDto = modelMapper.createTypeMap(StreamSiteFilmEntity.class, StreamSiteFilmDto.class);
        propertyMapperStreamSiteFilmDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getTittle(), StreamSiteFilmDto::setFilmName);
                    mapper.map(src -> src.getStreamSite().getName(), StreamSiteFilmDto::setStreamSiteName);
                }
        );

        //Episode
        TypeMap<EpisodeEntity, EpisodeDto> propertyMapperEpisodeDto = modelMapper.createTypeMap(EpisodeEntity.class, EpisodeDto.class);
        propertyMapperEpisodeDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getSerie().getId(), EpisodeDto::setSerieId);
                }
        );

        //Episode
        TypeMap<RatingEntity, RatingDto> propertyMapperRatingDto = modelMapper.createTypeMap(RatingEntity.class, RatingDto.class);
        propertyMapperRatingDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getId(), RatingDto::setFilmId);
                    mapper.map(src -> src.getUser().getId(), RatingDto::setUserId);
                }
        );

        //Comment
        TypeMap<CommentEntity, CommentDto> propertyMapperCommentDto = modelMapper.createTypeMap(CommentEntity.class, CommentDto.class);
        propertyMapperCommentDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getFilm().getId(), CommentDto::setFilmId);
                    mapper.map(src -> src.getUser().getId(), CommentDto::setUserId);
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

        //ParentChild
        TypeMap<PostEntity, PostDto> propertyMapperPostDto = modelMapper.createTypeMap(PostEntity.class, PostDto.class);
        propertyMapperPostDto.addMappings(
                mapper -> {
                    mapper.map(src -> src.getUser().getId(), PostDto::setUser);
                }
        );

        //UserToken
        TypeMap<UserEntity, RefreshTokenDto> propertyMapperRefreshTokenDto = modelMapper.createTypeMap(UserEntity.class, RefreshTokenDto.class);
        propertyMapperRefreshTokenDto.addMappings(
                mapper -> {
                    mapper.map(UserEntity::getId, RefreshTokenDto::setUser);
                }
        );

        return modelMapper;
    }
}
