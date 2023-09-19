package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.UserDto;
import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.services.UserService;
import com.ToorenRomaros.api.services.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/users/{id}")
    ResponseEntity<Map<String, Object>> updateUser(@PathVariable UUID id, @RequestBody @Valid UserEntity user) throws Exception {
        try{
            UserDto updatedUser = userService.updateUser(id, user);
            Map<String, Object> response = new HashMap<>();
            response.put("updated", updatedUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e ){
            log.info("error" + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    ResponseEntity<Map<String, Object>> createUser(@RequestBody @Valid UserEntity user) throws Exception {
        try {
            UserDto newUser = userService.createUser(user);
            Map<String, Object> response = new HashMap<>();
            response.put("created", newUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e ){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/users/{id}/followers")
    ResponseEntity<Map<String, Object>> getAllUserFollowersByUserId(@PathVariable @NotNull UUID id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) throws Exception {
        try{
        Pageable pageRequest = PageRequest.of(page,size);
        Page<User> pageFollowers = userService.getAllFollowersByUserId(id, pageRequest);
        Map<String, Object> response = new HashMap<>();
        response.put("followers", pageFollowers.getContent());
        response.put("currentPage", pageFollowers.getNumber());
        response.put("totalItems", pageFollowers.getNumberOfElements());
        response.put("totalPages", pageFollowers.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            log.info(e.getCause().toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    ResponseEntity<Map<String, Object>> getUser(@PathVariable @NotNull UUID id) throws Exception {
        try{
            Map<String, Object> response = new HashMap<>();
            response.put("response", userService.getUser(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

