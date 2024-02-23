package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.GetPostDetailsDto;
import com.ToorenRomaros.api.dto.publication.CreatePostDto;
import com.ToorenRomaros.api.dto.publication.GetPostDto;
import com.ToorenRomaros.api.dto.publication.UpdatePostDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.entities.media.ImageSizeEnum;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import com.ToorenRomaros.api.entities.tag.TagEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
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

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;
    private final TagRepository tagRepository;
    private final ImageRepostiroy imageRepostiroy;
    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    public PostServiceImpl(ModelMapper modelMapper, PostRepository postRepository, UserRepository userRepository, FilmRepository filmRepository, TagRepository tagRepository, ImageRepostiroy imageRepostiroy) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
        this.tagRepository = tagRepository;
        this.imageRepostiroy = imageRepostiroy;
    }

    @Override
    public CreatePostDto createPost(CreatePostDto createPostDto) {
        PostEntity postEntity = modelMapper.map(createPostDto, PostEntity.class);
        UserEntity userEntity = userRepository.findById(UUID.fromString(createPostDto.getUser())).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(createPostDto.getFilm())).orElseThrow(() -> new ResourceNotFoundException("Film not found"));
        TagEntity tagEntity = tagRepository.findById(UUID.fromString(createPostDto.getTag())).orElseThrow(() -> new ResourceNotFoundException("Tag not found"));
        postEntity.setUser(userEntity);
        postEntity.setFilm(filmEntity);
        postEntity.setTag(tagEntity);
        PostEntity savedPost = postRepository.save(postEntity);
        return modelMapper.map(savedPost, CreatePostDto.class);
    }

    @Override
    public GetPostDto getPostById(UUID id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post: " + id + " not found"));
        GetPostDto getPostDto = modelMapper.map(postEntity, GetPostDto.class);
        List<ImageEntity> imageEntities = imageRepostiroy.findAllImageByImageType("POST_MAIN", postEntity.getId().toString());
        if (!imageEntities.isEmpty()) {
            getPostDto.setMainImageId(imageEntities.get(0).getId().toString());
        }
        return getPostDto;
    }

    @Override
    public Map<String, Object> getTotalRatingByFilmId(UUID id) {
        List<Object[]> ratings = postRepository.getotalRatingsByFilmId(String.valueOf(id));
        Map<String, Object> values = new HashMap<>();
        values.put("positive", ratings.get(0)[0]);
        values.put("neutral", ratings.get(0)[1]);
        values.put("negative", ratings.get(0)[2]);
        return values;
    }

    @Override
    public Map<String, Object> getPostByCustomQuery(List<UUID> tags, boolean isReview, boolean latest, boolean popular, String searchQuery, int page, int size) throws SQLException {
        Map<String, Object> result = postRepository.findPostsMainInfoByLatestOrPopularOrTags(tags, isReview, latest,
                popular, searchQuery, page, size);
        List<PostEntity> postEntities = (List<PostEntity>) result.get("queryResult");
        result.replace("queryResult", postEntities.stream().map(postEntity -> {
            List<ImageEntity> imageEntity = imageRepostiroy.findAllImageByImageType("POST_MAIN", postEntity.getId().toString());
            GetPostDetailsDto getPostDetailsDto = modelMapper.map(postEntity, GetPostDetailsDto.class);
            findImageEntityByAttribute(imageEntity, ImageSizeEnum.ONE_DPI).ifPresentOrElse(
                    imageEntity1 -> getPostDetailsDto.setMainImageOneDpi(imageEntity1.getId().toString()),
                    () -> {
                    }
            );
            findImageEntityByAttribute(imageEntity, ImageSizeEnum.TWO_DPI).ifPresentOrElse(
                    imageEntity1 -> getPostDetailsDto.setMainImageTwoDpi(imageEntity1.getId().toString()),
                    () -> {
                    }
            );
            findImageEntityByAttribute(imageEntity, ImageSizeEnum.THREE_DPI).ifPresentOrElse(
                    imageEntity1 -> getPostDetailsDto.setMainImageThreeDpi(imageEntity1.getId().toString()),
                    () -> {
                    }
            );
            return getPostDetailsDto;
        }).collect(Collectors.toList()));
        return result;
    }

    public static Optional<ImageEntity> findImageEntityByAttribute(List<ImageEntity> imageEntities, ImageSizeEnum targetValue) {
        return imageEntities.stream()
                .filter(imageEntity -> targetValue.equals(imageEntity.getImageSize()))
                .findFirst();
    }

    @Override
    public Page<GetPostDetailsDto> getReviewPostsByFilmIdAndRatingOrderByField(UUID id, String rating, Pageable pageable) {
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
        Page<PostEntity> postEntities = postRepository.getReviewPostsByFilmIdAndRatingOrderByField(id, maxRating, lowRating, pageable);
        return postEntities.map(postEntity -> modelMapper.map(postEntity, GetPostDetailsDto.class));
    }

    @Override
    public Page<GetPostDetailsDto> getReviewPostsByFilmId(UUID id, Pageable pageable) {
        Page<PostEntity> postEntities = postRepository.getReviewPostsByFilmId(id, pageable);
        return postEntities.map(postEntity -> modelMapper.map(postEntity, GetPostDetailsDto.class));
    }

    @Override
    public GetPostDto updatePostById(UUID id, UpdatePostDto postDto) {
        PostEntity newPostEntity = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
        BeanUtils.copyProperties(postEntity, newPostEntity, Utils.getNullPropertyNames(postEntity));
        if (postDto.getTag() != null && !postDto.getTag().isEmpty()) {
            TagEntity tagEntity = tagRepository.getTagByName(postDto.getTag()).orElseThrow(() -> new ResourceNotFoundException("Tag not found"));
            postEntity.setTag(tagEntity);
        }
        PostEntity updatedPost = postRepository.save(newPostEntity);
        return modelMapper.map(updatedPost, GetPostDto.class);
    }

    @Override
    public Page<GetPostDetailsDto> getLatestReviewsByUserIdAndFilmType(UUID userId, int filmType, Pageable pageable) {
        Page<PostEntity> postEntities = postRepository.getLatestReviewsByUserIdAndFilmType(userId, filmType, pageable);

        return postEntities.map(postEntity -> {
            List<ImageEntity> imageEntity = imageRepostiroy.findAllImageByImageType("FILM_MAIN", postEntity.getFilm().getId().toString());
            GetPostDetailsDto getPostDetailsDto = modelMapper.map(postEntity, GetPostDetailsDto.class);
            if (!imageEntity.isEmpty()) {
                getPostDetailsDto.setFilmMainImageId(imageEntity.get(0).getId().toString());
            }
            return getPostDetailsDto;
        });
    }

    @Override
    public Page<GetPostDetailsDto> getLatestDraftsByUserId(UUID userId, Pageable pageable) {
        Page<PostEntity> postEntities = postRepository.getLatestDraftsByUserId(userId, pageable);

        return postEntities.map(postEntity -> {
            List<ImageEntity> imageEntity = imageRepostiroy.findAllImageByImageType("FILM_MAIN", postEntity.getFilm().getId().toString());
            GetPostDetailsDto getPostDetailsDto = modelMapper.map(postEntity, GetPostDetailsDto.class);
            if (!imageEntity.isEmpty()) {
                getPostDetailsDto.setFilmMainImageId(imageEntity.get(0).getId().toString());
            }
            return getPostDetailsDto;
        });
    }

    @Override
    public GetPostDetailsDto getLatestReviewPostByFilmIdAndUserIdAndRatingNotNull(UUID userId, UUID filmId) {
        PostEntity postEntity = postRepository.getLatestReviewPostByFilmIdAndUserIdAndRatingNotNull(userId.toString(), filmId.toString())
                .orElse(null);
        return modelMapper.map(postEntity, GetPostDetailsDto.class);
    }

    @Transactional
    @Override
    public void deletePostById(UUID id) {
        postRepository.findById(id)
                .ifPresentOrElse(postRepository::delete, () -> {
                    throw new ResourceNotFoundException("Post not found");
                });
        imageRepostiroy.findByOwner(id)
                .ifPresentOrElse(imageRepostiroy::delete, () -> {
                    throw new ResourceNotFoundException("Image not found");
                });
    }
}
