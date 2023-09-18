package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.repositories.UserFollowerRepository;
import com.ToorenRomaros.api.repositories.UserRepository;
import com.ToorenRomaros.api.utils.Utils;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserFollowerRepository userFollowerRepository;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, UserFollowerRepository userFollowerRepository) {
        this.userRepository = userRepository;
        this.userFollowerRepository = userFollowerRepository;
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
    public UserEntity updateUser(UUID id, UserEntity user) {
        UserEntity newUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "'"));
        try {
            log.info(Arrays.toString(Utils.getNullPropertyNames(user)));
            BeanUtils.copyProperties(user, newUser, Utils.getNullPropertyNames(user));
            return userRepository.saveAndFlush(newUser);
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> getAllFollowersByUserId(UUID id, Pageable pageRequest) {
        if (Strings.isBlank(id.toString())) {
            throw new UserNotFoundException("Invalid user.");
        }
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));

        List<UserFollowerEntity> entities = userFollowerRepository.findAllFollowersByUser(id.toString(), pageRequest);
        List<User> allFollowers = toModelList(entities);

        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), allFollowers.size());
        List<User> pageContent = allFollowers.subList(start, end);

        return new PageImpl<>(pageContent, pageRequest, allFollowers.size());
    }
}
