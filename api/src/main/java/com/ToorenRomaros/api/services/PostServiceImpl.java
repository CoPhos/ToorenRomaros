package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.PostDto;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.publication.PostRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

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
    public List<PostDto> getLatestPostsTittleAndHeadline() {
        List<PostEntity> postEntities = postRepository.getPostTittleAndPostHeadlineWhereStatusFinishedOrderByCreadtedDateDESCLimit8();
        if(postEntities == null){
            throw  new ResourceNotFoundException("No Posts found");
        }
        return postEntities.stream().map(postEntity -> modelMapper.map(postEntity, PostDto.class)).collect(Collectors.toList());
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
