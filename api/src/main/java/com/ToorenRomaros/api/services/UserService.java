package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.repositories.UserFollowerRepository;
import com.ToorenRomaros.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserFollowerRepository userFollowerRepository;

    public UserService(UserRepository userRepository, UserFollowerRepository userFollowerRepository) {
        this.userRepository = userRepository;
        this.userFollowerRepository = userFollowerRepository;
    }

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public Optional<UserEntity> getUserById(String username){
        return userRepository.findById(username);
    }

//    public List<UserEntity> findAllFollowersOf(String username){
//        return userRepository.findAllFollowersOf(username);
//    }

    public void deleteUserById(String id){
        userRepository.findById(id).map(userEntity -> {
                    userRepository.delete(userEntity);
                    return true;
                }).orElseThrow(() -> new RuntimeException("No user with id " + id));
    }

    public void addFollower(UserFollowerEntity userFollowerEntity) {
        userFollowerRepository.save(userFollowerEntity);
    }

    public List<UserFollowerEntity> findAllFollowersOf(String username) {

        //TODO column user from userFollowerEntity is type UserEntity and im passing a String, need to implement correctly this method that whats not working (i guess)
        //its doesnt work like find all followersById this is kinda custom filter idk need to dig deeper
        return userFollowerRepository.findAllFollowersOf(username);
    }
}
