package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.controllers.FilmController;
import com.ToorenRomaros.api.dto.publication.PostDetailsDto;
import com.ToorenRomaros.api.dto.publication.PostDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.publication.PostRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    public PostServiceImpl(ModelMapper modelMapper, PostRepository postRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
        UserEntity userEntity = userRepository.findById(UUID.fromString(postDto.getUser())).orElseThrow(() -> new ResourceNotFoundException("User: " + postDto.getUser() +  " not found"));
        postEntity.setUser(userEntity);
        PostEntity savedPost = postRepository.save(postEntity);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public PostDto getPostById(UUID id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post: " + id +  " not found"));
        return modelMapper.map(postEntity, PostDto.class);
    }

    @Override
    public Map<String, Object>getTotalRatingByFilmId(UUID id) {
        List<Object[]> ratings = postRepository.getotalRatingsByFilmId(String.valueOf(id));
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
    public Map<String, Object> getPostByCustomQuery(List<UUID> tags,  boolean isReview, boolean latest, boolean popular, int page, int size) {
        Map<String, Object> result = postRepository.findPostsMainInfoByLatestOrPopularOrTags(tags, isReview, latest,
                popular, page, size);
        List<PostEntity> postEntities = (List<PostEntity>) result.get("queryResult");
        if (postEntities == null) {
            throw new ResourceNotFoundException("No results");
        }
        result.replace("queryResult", postEntities.stream().map(postEntity -> {
            return modelMapper.map(postEntity, PostDetailsDto.class);
        }).collect(Collectors.toList()));
        return result;
    }

    @Override
    public Page<PostDetailsDto> getReviewPostsByFilmId(UUID id, Pageable pageable) {
       try{
           Page<PostEntity> postEntities = postRepository.getReviewPostsByFilmId(id, pageable);
           if (postEntities == null) {
               throw new ResourceNotFoundException("No results");
           }
           return postEntities.map(postEntity -> modelMapper.map(postEntity, PostDetailsDto.class));
       }catch (Exception e){
           log.info(e.getMessage());
           log.info(String.valueOf(e.getCause()));
       }
return null;
    }

    @Override
    public PostDto updatePostById(UUID id, PostDto postDto) {
        PostEntity newPostEntity = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post: " + id +  " not found"));
        PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);

        BeanUtils.copyProperties(postEntity, newPostEntity, Utils.getNullPropertyNames(postEntity));

        PostEntity updatedPost = postRepository.save(newPostEntity);

        return modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePostById(UUID id) {
        postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post: " + id +  " not found"));
        postRepository.deleteById(id);
    }
}
