package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.publication.CommentDto;
import com.ToorenRomaros.api.dto.publication.PostDto;
import com.ToorenRomaros.api.services.PostService;
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
@RequestMapping("api/v1")
public class PostController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/posts")
    ResponseEntity<Map<String, Object>> createPost(@RequestBody @Valid PostDto postDto) throws Exception {
        PostDto newPost = postService.createPost(postDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newPost);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    ResponseEntity<Map<String, Object>> getPostById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", postService.getPostById(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/posts/{id}")
    ResponseEntity<Map<String, Object>> updatePost(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                      @RequestBody PostDto postDto) throws Exception {
        PostDto updatedPost = postService.updatePostById(UUID.fromString(id), postDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedPost);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    ResponseEntity<String>  deletePost(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        postService.deletePostById(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Post: " + id + " deleted successfully");
    }
}
