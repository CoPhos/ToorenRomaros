package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    ResponseEntity<Map<String, Object>> createUser(@RequestBody @Valid UserEntity user) throws Exception {
        try {
            UserEntity newUser = userService.createUser(user);
            Map<String, Object> response = new HashMap<>();
            response.put("created", newUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e ){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/users/{username}/followers")
    ResponseEntity<Map<String, Object>> getAllUserFollowersByUserId(@PathVariable @NotNull String username, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) throws Exception {
        try{
        Pageable pageRequest = PageRequest.of(page,size);
        Page<User> pageFollowers = userService.getAllFollowersByUserId(username, pageRequest);
        Map<String, Object> response = new HashMap<>();
        response.put("followers", pageFollowers.getContent());
        response.put("currentPage", pageFollowers.getNumber());
        response.put("totalItems", pageFollowers.getNumberOfElements());
        response.put("totalPages", pageFollowers.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

