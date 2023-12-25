package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.*;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserTokenEntity;
import com.ToorenRomaros.api.exeptions.GenericAlreadyExistsException;
import com.ToorenRomaros.api.exeptions.InvalidRefreshTokenException;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.repositories.user.UserTokenRepository;
import com.ToorenRomaros.api.security.CustomUserDetails;
import com.ToorenRomaros.api.security.JwtManager;
import com.ToorenRomaros.api.utils.Utils;
import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserTokenRepository userTokenRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final JwtManager tokenManager;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, UserTokenRepository userTokenRepository, ModelMapper modelMapper, PasswordEncoder bCryptPasswordEncoder, JwtManager tokenManager) {
        this.userRepository = userRepository;
        this.userTokenRepository = userTokenRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenManager = tokenManager;
    }

    @Override
    public UserDto getUserById(UUID id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));
        return modelMapper.map(user, UserDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public UserDto updateUser(UUID id, UserAddRequestDto userAddRequestDto, String username) {
        UserEntity newUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "'"));
        UserEntity newData = modelMapper.map(userAddRequestDto, UserEntity.class);

        BeanUtils.copyProperties(newData, newUser, Utils.getNullPropertyNames(newData));

        UserEntity savedUser = userRepository.save(newUser);
        return modelMapper.map(savedUser, UserDto.class);

    }
    @Override
    @PreAuthorize("hasRole('adminrole')")
    public void deleteUserById(UUID id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "'"));
        userRepository.delete(user);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        if (Strings.isBlank(username)) {
            throw new UsernameNotFoundException("Invalid user.");
        }
        final String uname = username.trim();
        return userRepository.findByUsername(uname).orElseThrow(() -> new UsernameNotFoundException(String.format("Given user(%s) not found.", uname)));
    }

    @Override
    @Transactional
    public Optional<UserSignedInDto> createUser(CreateUserDto createUserDto) {
        Integer count = userRepository.findByUsernameOrEmail(createUserDto.getUsername(), createUserDto.getEmail());
        if (count > 0) {
            throw new GenericAlreadyExistsException("Use different username and email.");
        }
        UserEntity newUserEntity = modelMapper.map(createUserDto, UserEntity.class);
        String encodedPassword = bCryptPasswordEncoder.encode(createUserDto.getPassword());
        newUserEntity.setPassword(encodedPassword);
        UserEntity userEntity = userRepository.save(newUserEntity);

        return Optional.of(createSignedUserWithRefreshToken(userEntity));
    }

    @Override
    @Transactional
    public UserSignedInDto getSignedInUser(UserEntity userEntity) {
        userTokenRepository.deleteByUserId(userEntity.getId());
        return createSignedUserWithRefreshToken(userEntity);
    }

    @Override
    public Optional<UserSignedInDto> getAccessToken(RefreshTokenDto refreshTokenDto) {
        //TODO: implement time expiration
        return userTokenRepository.findByRefreshToken(refreshTokenDto.getRefreshToken())
                .map(userTokenEntity -> {
                    UserSignedInDto userSignedInDto = createSignedInUser(userTokenEntity.getUser());
                    userSignedInDto.setRefreshToken(createRefreshToken(userTokenEntity.getUser()));
                    userTokenRepository.delete(userTokenEntity);
                    return Optional.of(userSignedInDto).orElseThrow(() -> new InvalidRefreshTokenException("Invalid token."));
                });
    }

    @Override
    public void removeRefreshToken(RefreshTokenDto refreshTokenDto) {
        //TODO: implement blacklist token list????
        userTokenRepository.findByRefreshToken(refreshTokenDto.getRefreshToken())
                .ifPresentOrElse(userTokenRepository::delete, () -> {
                    throw new InvalidRefreshTokenException("Invalid token.");
                });
    }

    private UserSignedInDto createSignedUserWithRefreshToken(UserEntity userEntity) {
        UserSignedInDto userSignedInDto = createSignedInUser(userEntity);
        userSignedInDto.setRefreshToken(createRefreshToken(userEntity));
        return userSignedInDto;
    }

    private UserSignedInDto createSignedInUser(UserEntity userEntity) {
        String token;

//           token = tokenManager.create(org.springframework.security.core.userdetails.User.builder()
//                    .username(userEntity.getUsername())
//                    .password(userEntity.getPassword())
//                    .authorities(Objects.nonNull(userEntity.getRole()) ? userEntity.getRole().name() : "")
//                    .build());
        token = tokenManager.create(new CustomUserDetails(
                userEntity.getUsername(),
                userEntity.getPassword(),
                Objects.nonNull(userEntity.getRole()) ? userEntity.getRole().name() : ""));

        return new UserSignedInDto(userEntity.getUsername(), token, userEntity.getId().toString());
    }

    private String createRefreshToken(UserEntity user) {
        String token = RandomHolder.randomKey(128);
        userTokenRepository.save(new UserTokenEntity().setRefreshToken(token).setUser(user));
        return token;
    }

    private static class RandomHolder {
        static final Random random = new SecureRandom();
        public static String randomKey(int length) {
            return String.format("%"+length+"s", new BigInteger(length*5/*base 32,2^5*/, random)
                    .toString(32)).replace('\u0020', '0');
        }
    }
}
