package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.CommentDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.publication.CommentEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.publication.CommentRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{

    private final UserRepository userRepository;
    private final FilmRepository filmRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(UserRepository userRepository, FilmRepository filmRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Map<String, Object>getTotalRatingByFilmId(UUID id) {
        List<Object[]> ratings = commentRepository.getotalRatingsByFilmId(String.valueOf(id));
        if(ratings.isEmpty()){
            throw new ResourceNotFoundException("No ratings found for film:" + id);
        }
        Map<String, Object> values = new HashMap<>();
        values.put("positive", ratings.get(0)[0]);
        values.put("neutral", ratings.get(0)[1]);
        values.put("negative", ratings.get(0)[2]);
        return values;
    }
    @Override
    public CommentDto createComment(CommentDto commentDto) {
        CommentEntity commentEntity = modelMapper.map(commentDto, CommentEntity.class);
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(commentDto.getFilmId())).orElseThrow(() -> new ResourceNotFoundException("Film: " + commentDto.getFilmId() +  " not found"));
        UserEntity userEntity = userRepository.findById(UUID.fromString(commentDto.getUserId())).orElseThrow(() -> new ResourceNotFoundException("User: " + commentDto.getUserId() +  " not found"));
        commentEntity.setFilm(filmEntity);
        commentEntity.setUser(userEntity);
        CommentEntity savedComment = commentRepository.save(commentEntity);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public CommentDto getCommentById(UUID id) {
        CommentEntity comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment: " + id +  " not found"));
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public List<CommentDto> getAllCommentByUserId(UUID id, String reported) {
        List<CommentEntity> commentEntities = commentRepository.getAllCommentsByUserIdAndReported(id.toString(), reported);
        if(commentEntities.isEmpty()){
            throw new ResourceNotFoundException("No comments found for user: " + id);
        }
        return commentEntities.stream().map(commentEntity -> {
            return modelMapper.map(commentEntity, CommentDto.class);
        }).collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getAllCommentByFilmId(UUID id, Boolean reported) {
        List<CommentEntity> commentEntities = commentRepository.getAllCommentsByFilmIdAndReported(id.toString(), reported);
        if(commentEntities.isEmpty()){
            throw new ResourceNotFoundException("No comments found for film: " + id);
        }
        return commentEntities.stream().map(commentEntity -> {
            return modelMapper.map(commentEntity, CommentDto.class);
        }).collect(Collectors.toList());
    }

    @Override
    public CommentDto updateComment(UUID id, CommentDto commentDto) {
        CommentEntity newCommentEntity = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment: " + id + " not found"));
        CommentEntity commentEntity = modelMapper.map(commentDto, CommentEntity.class);
        BeanUtils.copyProperties(commentEntity, newCommentEntity, Utils.getNullPropertyNames(commentEntity));

        if(commentDto.getUserId() != null){
            UserEntity userEntity = userRepository.findById(UUID.fromString(commentDto.getUserId())).orElseThrow(() -> new ResourceNotFoundException("User: " + commentDto.getUserId() +  " not found"));
            newCommentEntity.setUser(userEntity);
        }
        if(commentDto.getFilmId() != null){
            FilmEntity filmEntity = filmRepository.findById(UUID.fromString(commentDto.getFilmId())).orElseThrow(() -> new ResourceNotFoundException("Film: " + commentDto.getFilmId() +  " not found"));
            newCommentEntity.setFilm(filmEntity);
        }

        CommentEntity updatedComment = commentRepository.save(newCommentEntity);
        return modelMapper.map(updatedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(UUID id) {
        commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment: " + id +  " not found"));
        commentRepository.deleteById(id);
    }
}
