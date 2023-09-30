package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.user.*;
import com.ToorenRomaros.api.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    ResponseEntity<Map<String, Object>> createUser(@RequestBody @Valid UserAddRequestDto userAddRequestDto) throws Exception {
        UserDto newUser = userService.createUser(userAddRequestDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newUser);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/users/{id}")
    ResponseEntity<Map<String, Object>> getUserById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", userService.getUserById(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/users/{id}")
    ResponseEntity<Map<String, Object>> updateUser(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid UserAddRequestDto userAddRequestDto) throws Exception {
        UserDto updatedUser = userService.updateUser(UUID.fromString(id), userAddRequestDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/users/{id}")
    ResponseEntity<String> deleteUserById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        userService.deleteUserById(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("User: " + id + " deleted successfully");
    }

    @PostMapping("/users/{username}/followers")
    ResponseEntity<Map<String, Object>> createFollower(@PathVariable @NotNull String username, @RequestBody @NotNull UserAddFollowerOrFollowingRequestDto requestDto) throws Exception {
        UserFollowerDto newFollow = userService.addFollowerByIds(UUID.fromString(requestDto.getUserId()), UUID.fromString(requestDto.getToFollowId()), username);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newFollow);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/followings")
    ResponseEntity<Map<String, Object>> createFollowing(@PathVariable @NotNull String username, @RequestBody @NotNull UserAddFollowerOrFollowingRequestDto requestDto) throws Exception {
        UserFollowerDto newFollow = userService.addFollowingsByIds(UUID.fromString(requestDto.getUserId()), UUID.fromString(requestDto.getToFollowId()), username);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newFollow);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/users/{username}/followers")
    ResponseEntity<String> deleteFollower(@PathVariable @NotNull String username, @RequestBody @NotNull UserAddFollowerOrFollowingRequestDto requestDto) throws Exception {
        userService.deleteFollowerByids(UUID.fromString(requestDto.getToFollowId()), UUID.fromString(requestDto.getUserId()), username);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Unfollow: " + requestDto.getToFollowId());
    }

    @DeleteMapping("/users/{username}/followings")
    ResponseEntity<String> deleteFollowing(@PathVariable @NotNull String username, @RequestBody @NotNull UserAddFollowerOrFollowingRequestDto requestDto) throws Exception {
        userService.deleteFollowingsByids(UUID.fromString(requestDto.getToFollowId()), UUID.fromString(requestDto.getUserId()), username);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Unfollow: " + requestDto.getUserId());
    }

    @GetMapping("/users/{id}/followers")
    ResponseEntity<Map<String, Object>> getAllUserFollowersByUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) throws Exception {
        Pageable pageRequest = PageRequest.of(page, size);
        Page<UserFollowerDto> pageFollowers = userService.getAllFollowersByUserId(UUID.fromString(id), pageRequest);
        Map<String, Object> response = new HashMap<>();
        response.put("followers", pageFollowers.getContent());
        response.put("currentPage", pageFollowers.getNumber());
        response.put("totalItems", pageFollowers.getNumberOfElements());
        response.put("totalPages", pageFollowers.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/users/{id}/followings")
    ResponseEntity<Map<String, Object>> getAllUserFollowingsByUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) throws Exception {
        Pageable pageRequest = PageRequest.of(page, size);
        Page<UserFollowingDto> pageFollowers = userService.getAllFollowingsByUserId(UUID.fromString(id), pageRequest);
        Map<String, Object> response = new HashMap<>();
        response.put("followings", pageFollowers.getContent());
        response.put("currentPage", pageFollowers.getNumber());
        response.put("totalItems", pageFollowers.getNumberOfElements());
        response.put("totalPages", pageFollowers.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}