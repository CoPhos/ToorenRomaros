package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{username}")
    ResponseEntity<List<User>> findById(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserFollowersByUserId(username));
    }
}
