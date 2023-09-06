package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public List<UserEntity> getUserById(String username){
        return userRepository.findUserById(username);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
