package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface UserService {

    User toModel(UserFollowerEntity e);
    List<User> toModelList(List<UserFollowerEntity> items);
    public Page<User> getAllFollowersByUserId(UUID id, Pageable pageRequest);

    public UserEntity createUser(UserEntity user);

    public UserEntity updateUser(UUID id, UserEntity user);
}
