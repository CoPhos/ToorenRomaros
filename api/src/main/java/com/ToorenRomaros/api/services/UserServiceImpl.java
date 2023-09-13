package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.repositories.UserFollowerRepository;
import com.ToorenRomaros.api.repositories.UserRepository;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Page<User> getUserFollowersByUserId(String username, Pageable pageRequest) {
        log.info("username: " + username);
        if (Strings.isBlank(username)) {
            throw new UserNotFoundException("Invalid user.");
        }
        userRepository.findById(username).orElseThrow(() -> new UserNotFoundException("'" + username + "' does not exists"));

        List<UserFollowerEntity> entities = userFollowerRepository.findAllFollowersByUser(username, pageRequest);
        List<User> allFollowers = toModelList(entities);

        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), allFollowers.size());
        List<User> pageContent = allFollowers.subList(start, end);

        return new PageImpl<>(pageContent, pageRequest, allFollowers.size());
    }
}
