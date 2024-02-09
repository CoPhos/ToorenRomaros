package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.PostDetailsDto;
import com.ToorenRomaros.api.dto.publication.PostDto;
import com.ToorenRomaros.api.dto.publication.UpdatePostDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import com.ToorenRomaros.api.entities.tag.TagEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.publication.PostRepository;
import com.ToorenRomaros.api.repositories.tag.TagRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;
    private final TagRepository tagRepository;
    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    public PostServiceImpl(ModelMapper modelMapper, PostRepository postRepository, UserRepository userRepository, FilmRepository filmRepository, TagRepository tagRepository) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
        UserEntity userEntity = userRepository.findById(UUID.fromString(postDto.getUser())).orElseThrow(() -> new ResourceNotFoundException("User: " + postDto.getUser() +  " not found"));
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(postDto.getFilm())).orElseThrow(() -> new ResourceNotFoundException("Film: " + postDto.getFilm() +  " not found"));
        TagEntity tagEntity = tagRepository.findById(UUID.fromString(postDto.getTag())).orElseThrow(() -> new ResourceNotFoundException("Tag: " + postDto.getTag() +  " not found"));
        postEntity.setUser(userEntity);
        postEntity.setFilm(filmEntity);
        postEntity.setTag(tagEntity);
        PostEntity savedPost = postRepository.save(postEntity);
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
        result.replace("queryResult", postEntities.stream().map(postEntity -> {
            return modelMapper.map(postEntity, PostDetailsDto.class);
        }).collect(Collectors.toList()));
        return result;
    }

    @Override
    public Page<PostDetailsDto> getReviewPostsByFilmIdAndRatingOrderByField(UUID id, String rating, Pageable pageable) {
        int maxRating;
        int lowRating;
        switch (rating){
            case "positive":
                maxRating=100;
                lowRating=70;
                break;
            case "neutral":
                maxRating=69;
                lowRating=40;
                break;
            case "negative":
                maxRating=39;
                lowRating=0;
                break;
            default:
                maxRating=100;
                lowRating=0;
        }
        Page<PostEntity> postEntities = postRepository.getReviewPostsByFilmIdAndRatingOrderByField(id,maxRating, lowRating, pageable);
        return postEntities.map(postEntity -> modelMapper.map(postEntity, PostDetailsDto.class));
    }

    @Override
    public Page<PostDetailsDto> getReviewPostsByFilmId(UUID id, Pageable pageable) {
           Page<PostEntity> postEntities = postRepository.getReviewPostsByFilmId(id, pageable);
           return postEntities.map(postEntity -> modelMapper.map(postEntity, PostDetailsDto.class));
    }

    @Override
    public PostDto updatePostById(UUID id, UpdatePostDto postDto) {
        PostEntity newPostEntity = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post: " + id +  " not found"));
        PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
        BeanUtils.copyProperties(postEntity, newPostEntity, Utils.getNullPropertyNames(postEntity));
        if(!postDto.getTag().isBlank()){
            TagEntity tagEntity = tagRepository.findById(UUID.fromString(postDto.getTag())).orElseThrow(() -> new ResourceNotFoundException("Tag: " + postDto.getTag() +  " not found"));
            postEntity.setTag(tagEntity);
        }
        PostEntity updatedPost = postRepository.save(newPostEntity);
        return modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public PostDetailsDto getLatestReviewPostByFilmIdAndUserIdAndRatingNotNull(UUID userId, UUID filmId) {
        PostEntity postEntity = postRepository.getLatestReviewPostByFilmIdAndUserIdAndRatingNotNull(userId.toString(), filmId.toString())
                .orElse(null);
        return modelMapper.map(postEntity, PostDetailsDto.class);
    }

    @Override
    public void deletePostById(UUID id) {
        postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post: " + id +  " not found"));
        postRepository.deleteById(id);
    }
}
