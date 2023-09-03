package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.User;
import com.ToorenRomaros.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getUser(String username){
        return userRepository.findUserById(username);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
