package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.services.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

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

    @GetMapping("/users/{username}")
    ResponseEntity<Map<String, Object>> findById(@PathVariable @NotNull String username, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) throws Exception {
        Pageable pageRequest = PageRequest.of(page,size);

        Page<User> pageFollowers = userService.getUserFollowersByUserId(username, pageRequest);
        Map<String, Object> response = new HashMap<>();
        response.put("followers", pageFollowers.getContent());
        response.put("currentPage", pageFollowers.getNumber());
        response.put("totalItems", pageFollowers.getNumberOfElements());
        response.put("totalPages", pageFollowers.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);}
    }

