package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public Optional<UserEntity> getUserById(String username){
        return userRepository.findById(username);
    }

    public List<UserEntity> findAllFollowersOf(String username){
        return userRepository.findAllFollowersOf(username);
    }

    public void deleteUserById(String id){
        userRepository.findById(id).map(userEntity -> {
                    userRepository.delete(userEntity);
                    return true;
                }).orElseThrow(() -> new RuntimeException("No user with id " + id));
    }
}
