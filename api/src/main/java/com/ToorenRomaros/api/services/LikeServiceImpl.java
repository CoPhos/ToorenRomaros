package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.CreateLikeDto;
import com.ToorenRomaros.api.dto.publication.DeleteLikeDto;
import com.ToorenRomaros.api.repositories.publication.CommentRepository;
import com.ToorenRomaros.api.repositories.publication.LikeRepository;
import com.ToorenRomaros.api.repositories.publication.PostRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;

public class LikeServiceImpl implements LikeService{
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public LikeServiceImpl(LikeRepository likeRepository, UserRepository userRepository, CommentRepository commentRepository, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void addLike(CreateLikeDto createLikeDto) {

    }

    @Override
    public void removeLike(DeleteLikeDto deleteLikeDto) {

    }
}
