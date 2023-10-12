package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.UserAddRequestDto;
import com.ToorenRomaros.api.dto.user.UserDto;


import java.util.List;
import java.util.UUID;

public interface UserService {
    public UserDto createUser(UserAddRequestDto userAddRequestDto);
    public UserDto updateUser(UUID id, UserAddRequestDto user, String username);
    public UserDto getUserById(UUID id);
    public void deleteUserById(UUID id);
}
