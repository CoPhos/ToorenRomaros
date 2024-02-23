package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.CreateCommentDto;
import com.ToorenRomaros.api.dto.publication.GetCommentDto;
import com.ToorenRomaros.api.dto.publication.UpdateCommentDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.entities.publication.CommentEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import com.ToorenRomaros.api.repositories.publication.CommentRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;
    private final CommentRepository commentRepository;
    private final ImageRepostiroy imageRepostiroy;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(UserRepository userRepository, FilmRepository filmRepository, CommentRepository commentRepository, ImageRepostiroy imageRepostiroy, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
        this.commentRepository = commentRepository;
        this.imageRepostiroy = imageRepostiroy;
        this.modelMapper = modelMapper;
    }

    @Override
    public Map<String, Object> getTotalRatingByFilmId(UUID id) {
        List<Object[]> ratings = commentRepository.getotalRatingsByFilmId(String.valueOf(id));
        Map<String, Object> values = new HashMap<>();
        values.put("positive", ratings.get(0)[0]);
        values.put("neutral", ratings.get(0)[1]);
        values.put("negative", ratings.get(0)[2]);
        return values;
    }

    @Override
    public Page<GetCommentDto> getAllCommentByFilmIdAndRatingOrderByField(UUID id, Boolean reported, String rating, Pageable pageable) {
        int maxRating;
        int lowRating;
        switch (rating) {
            case "positive":
                maxRating = 100;
                lowRating = 70;
                break;
            case "neutral":
                maxRating = 69;
                lowRating = 40;
                break;
            case "negative":
                maxRating = 39;
                lowRating = 0;
                break;
            default:
                maxRating = 100;
                lowRating = 0;
        }
        Page<CommentEntity> commentEntities = commentRepository.getAllCommentByFilmIdAndRatingOrderByField(id, reported, maxRating, lowRating, pageable);

        return commentEntities.map(commentEntity -> {
            List<ImageEntity> imageEntities = imageRepostiroy.findAllImageByImageType("FILM_MAIN", commentEntity.getFilm().getId().toString());
            if (!imageEntities.isEmpty()) {
                GetCommentDto getCommentDto = modelMapper.map(commentEntity, GetCommentDto.class);
                getCommentDto.setMainImageId(imageEntities.get(0).getId().toString());
                getCommentDto.setFilmName(commentEntity.getFilm().getTittle());
                return getCommentDto;
            } else {
                return modelMapper.map(commentEntity, GetCommentDto.class);
            }
        });
    }

    @Override
    @Transactional
    public GetCommentDto createComment(CreateCommentDto createCommentDto) {
        CommentEntity commentEntity = modelMapper.map(createCommentDto, CommentEntity.class);
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(createCommentDto.getFilmId())).orElseThrow(() -> new ResourceNotFoundException("Film not found"));
        UserEntity userEntity = userRepository.findById(UUID.fromString(createCommentDto.getUserId())).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        commentEntity.setFilm(filmEntity);
        commentEntity.setUser(userEntity);
        CommentEntity savedComment = commentRepository.save(commentEntity);
        return modelMapper.map(savedComment, GetCommentDto.class);
    }
    @Override
    public GetCommentDto getCommentById(UUID id) {
        CommentEntity comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        return modelMapper.map(comment, GetCommentDto.class);
    }
    @Override
    public GetCommentDto getCommentByFilmIdAndUserId(UUID filmId, UUID userId) {
        CommentEntity commentEntity = commentRepository.getCommentByFilmIdAndUserId(filmId.toString(), userId.toString()).orElseThrow(() -> new ResourceNotFoundException("No Post Found."));
        return modelMapper.map(commentEntity, GetCommentDto.class);
    }
    @Override
    public Page<GetCommentDto> getAllCommentsByUserIdAndReportedAndFilmType(UUID id, Boolean reported, int filmType, Pageable pageable) {
        Page<CommentEntity> commentEntities = commentRepository.getAllCommentsByUserIdAndReportedAndFilmType(id, reported, filmType, pageable);
        return commentEntities.map(commentEntity -> {
            List<ImageEntity> imageEntities = imageRepostiroy.findAllImageByImageType("FILM_MAIN", commentEntity.getFilm().getId().toString());
            if (!imageEntities.isEmpty()) {
                GetCommentDto getCommentDto = modelMapper.map(commentEntity, GetCommentDto.class);
                getCommentDto.setMainImageId(imageEntities.get(0).getId().toString());
                getCommentDto.setFilmName(commentEntity.getFilm().getTittle());
                return getCommentDto;
            } else {
                return modelMapper.map(commentEntity, GetCommentDto.class);
            }
        });
    }
    @Override
    public Page<GetCommentDto> getAllCommentByFilmId(UUID id, Boolean reported, Pageable pageable) {
        Page<CommentEntity> commentEntities = commentRepository.getAllCommentsByFilmIdAndReported(id, reported, pageable);
        return commentEntities.map(commentEntity -> modelMapper.map(commentEntity, GetCommentDto.class));
    }
    @Override
    public GetCommentDto updateComment(UUID id, UpdateCommentDto updateCommentDto) {
        CommentEntity newCommentEntity = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found."));
        CommentEntity commentEntity = modelMapper.map(updateCommentDto, CommentEntity.class);
        BeanUtils.copyProperties(commentEntity, newCommentEntity, Utils.getNullPropertyNames(commentEntity));
        CommentEntity updatedComment = commentRepository.save(newCommentEntity);
        return modelMapper.map(updatedComment, GetCommentDto.class);
    }

    @Override
    public void deleteComment(UUID id) {
        commentRepository.findById(id)
                .ifPresentOrElse(commentRepository::delete, () -> {
                    throw new UserNotFoundException("Comment not found.");
                });
    }
}
