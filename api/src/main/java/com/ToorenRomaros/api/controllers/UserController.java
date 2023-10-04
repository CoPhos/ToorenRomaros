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
@RequestMapping(value = "${api.baseUri}")
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
}