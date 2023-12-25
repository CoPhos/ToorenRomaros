package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.*;
import com.ToorenRomaros.api.entities.user.UserEntity;
import org.springframework.security.core.userdetails.User;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    public UserDto updateUser(UUID id, UserAddRequestDto user, String username);
    public UserDto getUserById(UUID id);
    public void deleteUserById(UUID id);
    UserEntity findUserByUsername(String username);
    Optional<UserSignedInDto> createUser(CreateUserDto createUserDto);
    UserSignedInDto getSignedInUser(UserEntity userEntity);
    Optional<UserSignedInDto> getAccessToken(RefreshTokenDto refreshTokenDto);
    void removeRefreshToken(RefreshTokenDto refreshTokenDto);
}
