package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.DiscussDto;
import com.ToorenRomaros.api.entities.publication.DiscussEntity;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.publication.DiscussRepository;
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
public class DiscussServiceImpl implements DiscussService{
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final DiscussRepository discussRepository;

    public DiscussServiceImpl(ModelMapper modelMapper, PostRepository postRepository, UserRepository userRepository, DiscussRepository discussRepository) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.discussRepository = discussRepository;
    }

    @Override
    public DiscussDto createDiscuss(DiscussDto discussDto) {
        DiscussEntity newDiscuss = modelMapper.map(discussDto, DiscussEntity.class);
        PostEntity postEntity = postRepository.findById(UUID.fromString(discussDto.getPostId())).orElseThrow(() -> new ResourceNotFoundException("Post: " + discussDto.getPostId() +  " not found"));
        UserEntity userEntity = userRepository.findById(UUID.fromString(discussDto.getUserId())).orElseThrow(() -> new ResourceNotFoundException("User: " + discussDto.getUserId() +  " not found"));
        newDiscuss.setPost(postEntity);
        newDiscuss.setUser(userEntity);
        DiscussEntity savedDiscuss = discussRepository.save(newDiscuss);
        return modelMapper.map(savedDiscuss, DiscussDto.class);
    }

    @Override
    public List<DiscussDto> getAllDiscussByPostId(UUID postId, boolean reported) {
        List<DiscussEntity> discussEntities = discussRepository.findAllDiscussByPostId(postId.toString(), reported);
        return discussEntities.stream().map(discussEntity -> modelMapper.map(discussEntity, DiscussDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<DiscussDto> getAllChildDiscussFromParentDiscussId(UUID discussId, boolean reported) {
        List<DiscussEntity> discussEntities = discussRepository.findAllChildDiscussByParentDiscussId(discussId.toString(), reported);
        return discussEntities.stream().map(discussEntity -> modelMapper.map(discussEntity, DiscussDto.class)).collect(Collectors.toList());
    }

    @Override
    public DiscussDto updateDiscuus(UUID discussId, DiscussDto discussDto) {
        DiscussEntity newDiscuss = discussRepository.findById(discussId).orElseThrow(() -> new ResourceNotFoundException("Discuss: " + discussId +  " not found"));
        DiscussEntity discussEntity = modelMapper.map(discussDto, DiscussEntity.class);
        BeanUtils.copyProperties(discussEntity, newDiscuss, Utils.getNullPropertyNames(discussEntity));

        if(discussDto.getUserId()!= null){
            UserEntity userEntity = userRepository.findById(UUID.fromString(discussDto.getUserId())).orElseThrow(() -> new ResourceNotFoundException("User: " + discussDto.getUserId() +  " not found"));
            newDiscuss.setUser(userEntity);
        }
        if(discussDto.getPostId() != null){
            PostEntity postEntity = postRepository.findById(UUID.fromString(discussDto.getPostId())).orElseThrow(() -> new ResourceNotFoundException("Post: " + discussDto.getPostId() +  " not found"));
            newDiscuss.setPost(postEntity);
        }
        DiscussEntity savedDiscuss = discussRepository.save(newDiscuss);

        return modelMapper.map(savedDiscuss, DiscussDto.class);
    }

    @Override
    public void deleteDiscuss(UUID id) {
        discussRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Discuss: " + id +  " not found"));
        discussRepository.deleteById(id);
    }
}
