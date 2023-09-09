package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.models.User;

import java.util.List;

public interface UserService {

    User toModel(UserEntity e);
    List<User> toModelList(List<UserEntity> items);
    public List<User> getUserFollowersByUserId(String customerId);
}
