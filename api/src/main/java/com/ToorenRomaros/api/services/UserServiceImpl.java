package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.UserAddRequestDto;
import com.ToorenRomaros.api.dto.user.UserDto;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.dto.user.UserFollowingDto;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.user.UserFollowerRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserFollowerRepository userFollowerRepository;
    private final ModelMapper modelMapper;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, UserFollowerRepository userFollowerRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userFollowerRepository = userFollowerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserAddRequestDto userAddRequestDto) {
        UserEntity user = modelMapper.map(userAddRequestDto, UserEntity.class);
        user.setFollowers(new ArrayList<>());
        user.setFollowings(new ArrayList<>());

        userRepository.save(user);
        if (userAddRequestDto.getFollowers() != null) {
            for (String value : userAddRequestDto.getFollowers()) {
                UserEntity newFollower = userRepository.findById(UUID.fromString(value)).orElseThrow(() -> new UserNotFoundException("'" + value + "' does not exists"));
                UserFollowerEntity userFollowerEntity = new UserFollowerEntity(LocalDate.now(), newFollower, user);
                user.getFollowers().add(userFollowerEntity);
                userFollowerRepository.save(userFollowerEntity);
            }
        }
        if (userAddRequestDto.getFollowings() != null) {
            for (String value : userAddRequestDto.getFollowings()) {
                UserEntity newFollowing = userRepository.findById(UUID.fromString(value)).orElseThrow(() -> new UserNotFoundException("'" + value + "' does not exists"));
                UserFollowerEntity userFollowerEntity = new UserFollowerEntity(LocalDate.now(), user, newFollowing);
                user.getFollowings().add(userFollowerEntity);
                userFollowerRepository.save(userFollowerEntity);
            }
        }

        UserEntity savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(UUID id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));
        return modelMapper.map(user, UserDto.class);
    }


    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public UserDto updateUser(UUID id, UserAddRequestDto userAddRequestDto) {
        UserEntity newUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "'"));
        UserEntity user = modelMapper.map(userAddRequestDto, UserEntity.class);

        user.setFollowings(null);
        user.setFollowers(null);

        BeanUtils.copyProperties(user, newUser, Utils.getNullPropertyNames(user));
        userRepository.save(newUser);

        if (userAddRequestDto.getFollowers() != null) {
            for (String value : userAddRequestDto.getFollowers()) {
                UserEntity newFollower = userRepository.findById(UUID.fromString(value)).orElseThrow(() -> new UserNotFoundException("'" + value + "' does not exists"));
                UserFollowerEntity userFollowerEntity = new UserFollowerEntity(LocalDate.now(), newFollower, newUser);
                newUser.getFollowers().add(userFollowerEntity);
                userFollowerRepository.save(userFollowerEntity);
            }
        }
        if (userAddRequestDto.getFollowings() != null) {
            for (String value : userAddRequestDto.getFollowings()) {
                UserEntity newFollowing = userRepository.findById(UUID.fromString(value)).orElseThrow(() -> new UserNotFoundException("'" + value + "' does not exists"));
                UserFollowerEntity userFollowerEntity = new UserFollowerEntity(LocalDate.now(), newUser, newFollowing);
                newUser.getFollowings().add(userFollowerEntity);
                userFollowerRepository.save(userFollowerEntity);
            }
        }
        UserEntity savedUser = userRepository.save(newUser);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    @PreAuthorize("hasRole('adminrole')")
    public void deleteUserById(UUID id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "'"));
        userRepository.delete(user);
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public UserFollowerDto addFollowerByIds(UUID idUser, UUID toFollow, String username) {
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        UserEntity follower = userRepository.findById(toFollow).orElseThrow(() -> new UserNotFoundException("'" + toFollow + "'"));

        UserFollowerEntity newFollow = new UserFollowerEntity(LocalDate.now(), follower, user);
        user.getFollowers().add(newFollow);
        userRepository.save(user);

        return modelMapper.map(userFollowerRepository.save(newFollow), UserFollowerDto.class);
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public UserFollowerDto addFollowingsByIds(UUID idUser, UUID toFollow, String username) {
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        UserEntity follower = userRepository.findById(toFollow).orElseThrow(() -> new UserNotFoundException("'" + toFollow + "'"));

        UserFollowerEntity newFollow = new UserFollowerEntity(LocalDate.now(), user, follower);
        user.getFollowings().add(newFollow);
        userRepository.save(user);
        return modelMapper.map(userFollowerRepository.save(newFollow), UserFollowerDto.class);
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public void deleteFollowerByids(UUID idUser, UUID toFollow, String username) {
        UserFollowerEntity entity = userFollowerRepository.findByFollowerIdAndUserId(toFollow.toString(), idUser.toString()).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        userFollowerRepository.deleteById(entity.getId());
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        user.getFollowers().remove(entity);
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public void deleteFollowingsByids(UUID idUser, UUID toFollow, String username) {
        UserFollowerEntity entity = userFollowerRepository.findByFollowerIdAndUserId(idUser.toString(), toFollow.toString()).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        userFollowerRepository.deleteById(entity.getId());
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        user.getFollowings().remove(entity);
    }

    @Override
    public Page<UserFollowerDto> getAllFollowersByUserId(UUID id, Pageable pageRequest) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));

        List<UserFollowerEntity> entities = userFollowerRepository.findAllFollowersByUser(id.toString(), pageRequest);
        if (entities == null) {
            throw new ResourceNotFoundException("");
        }
        List<UserFollowerDto> allFollowers = entities.stream().map(value -> modelMapper.map(value, UserFollowerDto.class)).collect(Collectors.toList());

        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), allFollowers.size());
        List<UserFollowerDto> pageContent = allFollowers.subList(start, end);

        return new PageImpl<>(pageContent, pageRequest, allFollowers.size());
    }

    @Override
    public Page<UserFollowingDto> getAllFollowingsByUserId(UUID id, Pageable pageRequest) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));

        List<UserFollowerEntity> entities = userFollowerRepository.findAllFollowingsByUser(id.toString(), pageRequest);

        if (entities == null) {
            throw new ResourceNotFoundException("");
        }
        List<UserFollowingDto> allFollowers = entities.stream().map(value -> modelMapper.map(value, UserFollowingDto.class)).collect(Collectors.toList());

        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), allFollowers.size());
        List<UserFollowingDto> pageContent = allFollowers.subList(start, end);

        return new PageImpl<>(pageContent, pageRequest, allFollowers.size());
    }
}
