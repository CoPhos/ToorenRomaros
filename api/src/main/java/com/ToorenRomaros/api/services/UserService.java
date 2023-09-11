package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.models.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    User toModel(UserFollowerEntity e);
    List<User> toModelList(List<UserFollowerEntity> items);
    public List<User> getUserFollowersByUserId(String customerId);
}
