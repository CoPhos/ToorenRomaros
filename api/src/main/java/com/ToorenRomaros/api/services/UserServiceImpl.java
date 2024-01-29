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
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserTokenRepository userTokenRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final JwtManager tokenManager;
    private final PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, UserTokenRepository userTokenRepository, ModelMapper modelMapper, PasswordEncoder bCryptPasswordEncoder, JwtManager tokenManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userTokenRepository = userTokenRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenManager = tokenManager;
        this.passwordEncoder = passwordEncoder;
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
        userRepository.findById(id)
                .ifPresentOrElse(userRepository::delete, () -> {
                    throw new UserNotFoundException("'" + id + "'");
                });
    }

    @Override
    public UserSignedInDto signin(SignInDto signInDto) {
        UserEntity userEntity = userRepository.findByUsername(signInDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException(String.format("Given user(%s) not found.", signInDto.getUsername())));
        if (passwordEncoder.matches(signInDto.getPassword(), userEntity.getPassword())) {
            return getSignedInUser(userEntity);
        } else {
            throw new InsufficientAuthenticationException("Unauthorized.");
        }
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
    public void removeRefreshToken(String refreshToken) {
        //TODO: implement blacklist token list????
        userTokenRepository.findByRefreshToken(refreshToken)
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

        return new UserSignedInDto(userEntity.getUsername(), token,userEntity.getEmail(), userEntity.getId().toString());
    }

    private String createRefreshToken(UserEntity user) {
        String token = RandomHolder.randomKey(128);
        userTokenRepository.save(new UserTokenEntity().setRefreshToken(token).setUser(user));
        return token;
    }

    private static class RandomHolder {
        static final Random random = new SecureRandom();

        public static String randomKey(int length) {
            return String.format("%" + length + "s", new BigInteger(length * 5/*base 32,2^5*/, random)
                    .toString(32)).replace('\u0020', '0');
        }
    }
}
