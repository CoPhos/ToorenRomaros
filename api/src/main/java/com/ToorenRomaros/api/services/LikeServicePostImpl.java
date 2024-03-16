package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.CreateLikeDto;
import com.ToorenRomaros.api.entities.publication.LikeEntity;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.publication.LikeRepository;
import com.ToorenRomaros.api.repositories.publication.PostRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service("LikeServicePostImpl")
public class LikeServicePostImpl implements LikeService{
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public LikeServicePostImpl(LikeRepository likeRepository, UserRepository userRepository, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void addLike(CreateLikeDto createLikeDto) {
        UserEntity userEntity = userRepository.findById(UUID.fromString(createLikeDto.getUserId())).orElseThrow(() -> new UserNotFoundException("User not found."));
        PostEntity postEntity = postRepository.findById(UUID.fromString(createLikeDto.getOwnerId())).orElseThrow(() -> new ResourceNotFoundException("Post not found."));
        LikeEntity likeEntity = new LikeEntity();
        likeEntity.setUser(userEntity);
        likeEntity.setOwner(postEntity);
        likeRepository.save(likeEntity);
    }

    @Override
    public void removeLike(UUID ownerId, UUID userId) {
        likeRepository.getCommentByOwnerIdAndFilmId(ownerId, userId)
                .ifPresentOrElse(likeRepository::delete, () -> {
                    throw new ResourceNotFoundException("Relationship not found");
                });
    }
}
