package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.UserAddRequestDto;
import com.ToorenRomaros.api.dto.user.UserDto;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.dto.user.UserFollowingDto;
import com.ToorenRomaros.api.entities.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public Page<UserFollowerDto> getAllFollowersByUserId(UUID id, Pageable pageRequest);
    public Page<UserFollowingDto> getAllFollowingsByUserId(UUID id, Pageable pageRequest);
    public UserFollowerDto addFollowerByIds(UUID idUser, UUID toFollow, String username);
    public UserFollowerDto addFollowingsByIds(UUID idUser, UUID toFollow, String username);
    public void deleteFollowerByids(UUID idUser, UUID toFollow, String username);
    public void deleteFollowingsByids(UUID idUser, UUID toFollow, String username);
    public UserDto createUser(UserAddRequestDto userAddRequestDto);
    public UserDto updateUser(UUID id, UserAddRequestDto user);
    public UserDto getUserById(UUID id);
    public void deleteUserById(UUID id);

}
