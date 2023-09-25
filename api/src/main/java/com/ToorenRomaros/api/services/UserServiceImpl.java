package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.UserDto;
import com.ToorenRomaros.api.dto.UserFollowerDto;
import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.repositories.UserFollowerRepository;
import com.ToorenRomaros.api.repositories.UserRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

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
    public User toModel(UserFollowerEntity e) {
        User m = new User();
        m.setUsername(e.getFollower().getUsername());
        m.setFollowDate(e.getFollowDate());
        return m;
    }

    @Override
    public List<User> toModelList(List<UserFollowerEntity> followers) {
        if (Objects.isNull(followers)){
            return Collections.emptyList();
        }
        return followers.stream().map(this::toModel).collect(toList());
    }

    @Override
    public UserDto createUser(UserEntity user) {
        try{
            return modelMapper.map(userRepository.save(user), UserDto.class);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public UserDto getUserById(UUID id) {
        try {
            UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));
            return modelMapper.map(user, UserDto.class);
        }catch (Exception e){
            return null;
        }
    }

    @PreAuthorize("#user.username == authentication.name || authentication.name == admin || authentication.name == mod")
    @Override
    public UserDto updateUser(UUID id, UserEntity user) {
        UserEntity newUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "'"));
        try {
            BeanUtils.copyProperties(user, newUser, Utils.getNullPropertyNames(user));
            return modelMapper.map(userRepository.save(newUser), UserDto.class);
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteUserById(UUID id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "'"));
        userRepository.delete(user);
    }


    @Override
    public UserFollowerDto addFollowerByIds(UUID idUser, UUID toFollow) {
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        UserEntity follower = userRepository.findById(toFollow).orElseThrow(() -> new UserNotFoundException("'" + toFollow + "'"));

        UserFollowerEntity newFollow = new UserFollowerEntity(LocalDate.now(), follower, user);
        user.getFollowers().add(newFollow);
        userRepository.save(user);
       return modelMapper.map(userFollowerRepository.save(newFollow), UserFollowerDto.class);
    }

    @Override
    public UserFollowerDto addFollowingsByIds(UUID idUser, UUID toFollow) {
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        UserEntity follower = userRepository.findById(toFollow).orElseThrow(() -> new UserNotFoundException("'" + toFollow + "'"));

        UserFollowerEntity newFollow = new UserFollowerEntity(LocalDate.now(), user, follower);
        user.getFollowings().add(newFollow);
        userRepository.save(user);
        return modelMapper.map(userFollowerRepository.save(newFollow), UserFollowerDto.class);
    }

    @Override
    public void deleteFollowingsByids(UUID idUser, UUID toFollow) {

    }

    @Override
    public void deleteFollowerByids(UUID idUser, UUID toFollow) {

    }

    @Override
    public Page<User> getAllFollowersByUserId(UUID id, Pageable pageRequest) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));

        List<UserFollowerEntity> entities = userFollowerRepository.findAllFollowersByUser(id.toString(), pageRequest);
        List<User> allFollowers = toModelList(entities);

        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), allFollowers.size());
        List<User> pageContent = allFollowers.subList(start, end);

        return new PageImpl<>(pageContent, pageRequest, allFollowers.size());
    }

    @Override
    public Page<User> getAllFollowingsByUserId(UUID id, Pageable pageRequest) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));

        List<UserFollowerEntity> entities = userFollowerRepository.findAllFollowingsByUser(id.toString(), pageRequest);
        List<User> allFollowers = toModelList(entities);

        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), allFollowers.size());
        List<User> pageContent = allFollowers.subList(start, end);

        return new PageImpl<>(pageContent, pageRequest, allFollowers.size());
    }
}
