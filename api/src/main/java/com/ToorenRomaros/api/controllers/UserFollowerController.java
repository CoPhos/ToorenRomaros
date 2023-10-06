package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.user.UserAddFollowRequestDto;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.services.UserFollowerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class UserFollowerController {
    private final UserFollowerService userFollowerService;
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";

    public UserFollowerController(UserFollowerService userFollowerService) {
        this.userFollowerService = userFollowerService;
    }

    @PostMapping("/users/{username}/follows")
    ResponseEntity<Map<String, Object>> createFollow(@PathVariable @NotNull String username, @RequestBody @NotNull UserAddFollowRequestDto requestDto) throws Exception {
        UserFollowerDto newFollow = userFollowerService.addFollow(UUID.fromString(requestDto.getUserId()), UUID.fromString(requestDto.getToFollowId()), username);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newFollow);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/users/{username}/follows")
    ResponseEntity<String> deleteFollowing(@PathVariable @NotNull String username, @RequestBody @NotNull UserAddFollowRequestDto requestDto) throws Exception {
        userFollowerService.deleteFollowByIds(UUID.fromString(requestDto.getToFollowId()), UUID.fromString(requestDto.getUserId()),  username);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Unfollow: " + requestDto.getUserId());
    }

    @GetMapping("/users/{id}/follows")
    ResponseEntity<Map<String, Object>> getAllFollowsByUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size, @RequestParam(defaultValue = "follower") @NotNull String type) throws Exception {
        Pageable pageRequest = PageRequest.of(page, size);
        Page<UserFollowerDto> pageFollowers = userFollowerService.getAllFollowsByUserIds(UUID.fromString(id), pageRequest, type);
        Map<String, Object> response = new HashMap<>();
        response.put(type, pageFollowers.getContent());
        response.put("currentPage", pageFollowers.getNumber());
        response.put("totalItems", pageFollowers.getNumberOfElements());
        response.put("totalPages", pageFollowers.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
