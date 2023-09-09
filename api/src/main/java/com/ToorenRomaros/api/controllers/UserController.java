package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.repositories.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @GetMapping("/users/{username}")
    public List<User> findById(@PathVariable String username){
        return userServiceImpl.getUserFollowersByUserId(username);
    }

}
