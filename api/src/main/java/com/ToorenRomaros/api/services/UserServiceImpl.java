package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.UserAddRequestDto;
import com.ToorenRomaros.api.dto.user.UserDto;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.dto.user.UserFollowingDto;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.user.UserFollowerRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public UserDto createUser(UserAddRequestDto userAddRequestDto) {
        UserEntity user = modelMapper.map(userAddRequestDto, UserEntity.class);
        UserEntity savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }
    @Override
    public UserDto getUserById(UUID id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));
        return modelMapper.map(user, UserDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public UserDto updateUser(UUID id, UserAddRequestDto userAddRequestDto) {
        UserEntity newUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "'"));
        UserEntity user = modelMapper.map(userAddRequestDto, UserEntity.class);

        BeanUtils.copyProperties(user, newUser, Utils.getNullPropertyNames(user));

        UserEntity savedUser = userRepository.save(newUser);
        return modelMapper.map(savedUser, UserDto.class);
    }
    @Override
    @PreAuthorize("hasRole('adminrole')")
    public void deleteUserById(UUID id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "'"));
        userRepository.delete(user);
    }
}
