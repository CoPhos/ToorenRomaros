package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.*;
import com.ToorenRomaros.api.entities.user.UserEntity;
import org.springframework.security.core.userdetails.User;


import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    public UserDto updateUser(UUID id, UserAddRequestDto user, String username);
    public UserDto getUserById(UUID id);
    public void deleteUserById(UUID id);
    UserSignedInDto signin(SignInDto signInDto);
    Optional<UserSignedInDto> createUser(CreateUserDto createUserDto);
    UserSignedInDto getSignedInUser(UserEntity userEntity);
    Optional<UserSignedInDto> getAccessToken(RefreshTokenDto refreshTokenDto);
    void removeRefreshToken(String refreshToken);
    UserSignedInDto createUserAndSignIn(UserEntity userEntity, String email, String name, HttpServletResponse response) throws UnsupportedEncodingException;
    void storeUserCookies(HttpServletResponse response, UserEntity userEntity, String accessToken, String refreshToken, String email, String name) throws UnsupportedEncodingException;
    void sendResetPasswordEmail(String email) throws MessagingException;
    void resetPassword(String token, String newPassword);
}
