package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.entities.User;
import com.ToorenRomaros.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public void add(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping("/users/{username}")
    public List<User> findById(@PathVariable String username){
        return userService.getUser(username);
    }

    @PreAuthorize("hasRole('adminrole')")
    @DeleteMapping("users/{id}")
    public void delete(@PathVariable String id){
        userService.deleteUser(id);
    }
}
