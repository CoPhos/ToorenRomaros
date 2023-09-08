package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public void add(@RequestBody UserEntity userEntity){
        userService.saveUser(userEntity);
    }

    @GetMapping("/users/{username}")
    public Optional<UserEntity> findById(@PathVariable String username){
        return userService.getUserById(username);
    }

    @GetMapping("/users/{username}/followers")
    public List<UserFollowerEntity> findFollowersOfUser(@PathVariable String username){
        return userService.findAllFollowersOf(username);
    }

    @PreAuthorize("hasRole('adminrole')")
    @DeleteMapping("users/{id}")
    public void delete(@PathVariable String id){
        userService.deleteUserById(id);
    }
}
