package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.publication.CommentDto;
import com.ToorenRomaros.api.services.CommentService;
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
public class CommentController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    ResponseEntity<Map<String, Object>> createComment(@RequestBody @Valid CommentDto commentDto) throws Exception {
        CommentDto newComment = commentService.createComment(commentDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newComment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/comments/{id}")
    ResponseEntity<Map<String, Object>> getCommentById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        CommentDto comment = commentService.getCommentById(UUID.fromString(id));
        Map<String, Object> response = new HashMap<>();
        response.put("created", comment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/users/{id}/comments")
    ResponseEntity<Map<String, Object>> getAllCommentByUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                              @RequestParam(defaultValue = "false") String reported) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("created", commentService.getAllCommentByUserId(UUID.fromString(id), reported));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/films/{id}/comments")
    ResponseEntity<Map<String, Object>> getAllCommentByFilmId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                              @RequestParam(defaultValue = "false") Boolean reported) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.getAllCommentByFilmId(UUID.fromString(id), reported));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/comments/{id}")
    ResponseEntity<Map<String, Object>> updateComment(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                      @RequestBody CommentDto commentDto) throws Exception {
        CommentDto updatedComment = commentService.updateComment(UUID.fromString(id),commentDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedComment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/comments/{id}")
    ResponseEntity<String>  deleteComment(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        commentService.deleteComment(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Comment: " + id + " deleted successfully");
    }
}