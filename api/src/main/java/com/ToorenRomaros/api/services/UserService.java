package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.UserDto;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import com.ToorenRomaros.api.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User toModel(UserFollowerEntity e);
    List<User> toModelList(List<UserFollowerEntity> items);
    public Page<User> getAllFollowersByUserId(UUID id, Pageable pageRequest);
    public Page<User> getAllFollowingsByUserId(UUID id, Pageable pageRequest);
    public UserFollowerDto addFollowerByIds(UUID idUser, UUID toFollow, String username);
    public UserFollowerDto addFollowingsByIds(UUID idUser, UUID toFollow, String username);
    public void deleteFollowerByids(UUID idUser, UUID toFollow, String username);
    public void deleteFollowingsByids(UUID idUser, UUID toFollow, String username);
    public UserDto createUser(UserEntity user);
    public UserDto updateUser(UUID id, UserEntity user);
    public UserDto getUserById(UUID id);
    public void deleteUserById(UUID id);

}
