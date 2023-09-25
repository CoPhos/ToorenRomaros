package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.UserAddFollowerOrFollowingRequestDto;
import com.ToorenRomaros.api.dto.UserDto;
import com.ToorenRomaros.api.dto.UserFollowerDto;
import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    ResponseEntity<Map<String, Object>> createUser(@RequestBody @Valid UserEntity user) throws Exception {
        try {
            UserDto newUser = userService.createUser(user);
            Map<String, Object> response = new HashMap<>();
            response.put("created", newUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e ){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{id}")
    ResponseEntity<Map<String, Object>> getUserById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        try{
            Map<String, Object> response = new HashMap<>();
            response.put("response", userService.getUserById(UUID.fromString(id)));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/users/{id}")
    ResponseEntity<Map<String, Object>> updateUser(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid UserEntity user) throws Exception {
        try{
            UserDto updatedUser = userService.updateUser(UUID.fromString(id), user);
            Map<String, Object> response = new HashMap<>();
            response.put("updated", updatedUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e ){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasRole('adminrole')")
    ResponseEntity<String> deleteUserById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        try{
            userService.deleteUserById(UUID.fromString(id));
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("User: " + id + " deleted successfully");
        }catch(Exception e ){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/users/follower")
    ResponseEntity<Map<String, Object>> createFollower(@RequestBody @NotNull UserAddFollowerOrFollowingRequestDto requestDto) throws Exception {
        try {
            UserFollowerDto newFollow = userService.addFollowerByIds(UUID.fromString(requestDto.getUserId()),UUID.fromString(requestDto.getToFollowId()));
            Map<String, Object> response = new HashMap<>();
            response.put("created", newFollow);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e ){
            log.info(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/users/following")
    ResponseEntity<Map<String, Object>> createFollowing(@RequestBody @NotNull UserAddFollowerOrFollowingRequestDto requestDto) throws Exception {
        try {
            UserFollowerDto newFollow = userService.addFollowingsByIds(UUID.fromString(requestDto.getUserId()),UUID.fromString(requestDto.getToFollowId()));
            Map<String, Object> response = new HashMap<>();
            response.put("created", newFollow);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e ){
            log.info(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{id}/followers")
    ResponseEntity<Map<String, Object>> getAllUserFollowersByUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) throws Exception {
        try{
        Pageable pageRequest = PageRequest.of(page,size);
        Page<User> pageFollowers = userService.getAllFollowersByUserId(UUID.fromString(id), pageRequest);
        Map<String, Object> response = new HashMap<>();
        response.put("followers", pageFollowers.getContent());
        response.put("currentPage", pageFollowers.getNumber());
        response.put("totalItems", pageFollowers.getNumberOfElements());
        response.put("totalPages", pageFollowers.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{id}/following")
    ResponseEntity<Map<String, Object>> getAllUserFollowingsByUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) throws Exception {
        try{
            Pageable pageRequest = PageRequest.of(page,size);
            Page<User> pageFollowers = userService.getAllFollowingsByUserId(UUID.fromString(id), pageRequest);
            Map<String, Object> response = new HashMap<>();
            response.put("following", pageFollowers.getContent());
            response.put("currentPage", pageFollowers.getNumber());
            response.put("totalItems", pageFollowers.getNumberOfElements());
            response.put("totalPages", pageFollowers.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}