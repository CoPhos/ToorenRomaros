package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.repositories.UserFollowerRepository;
import com.ToorenRomaros.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserFollowerRepository userFollowerRepository;

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
    public List<User> getUserFollowersByUserId(String username) {
        List<UserFollowerEntity> entities = userFollowerRepository.findAllFollowersByUser(username);
        return toModelList(entities);
    }
}
