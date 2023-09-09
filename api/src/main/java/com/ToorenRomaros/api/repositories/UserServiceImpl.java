package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserService userService;
    @Autowired
    private  UserRepository userRepository;


    @Override
    public User toModel(UserEntity e) {
        User m = new User();
        m.setUsername(e.getUsername());
        return m;
    }

    @Override
    public List<User> toModelList(List<UserEntity> followers) {
        if (Objects.isNull(followers)){
            return Collections.emptyList();
        }
        return followers.stream().map(e -> toModel(e)).collect(toList());
    }

    @Override
    public List<User> getUserFollowersByUserId(String username) {
        List<UserEntity> entities = userRepository.findAllById(Collections.singleton(username));

        return userService.toModelList(entities.get(0).getFollowers());
    }
}
