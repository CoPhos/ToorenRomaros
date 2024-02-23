package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.publication.CreateCommentDto;
import com.ToorenRomaros.api.dto.publication.UpdateCommentDto;
import com.ToorenRomaros.api.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    ResponseEntity<Map<String, Object>> createComment(@RequestBody @Valid CreateCommentDto createCommentDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.createComment(createCommentDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/comments/{id}")
    ResponseEntity<Map<String, Object>> getCommentById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.getCommentById(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/comments")
    ResponseEntity<Map<String, Object>> getAllCommentByUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId,
                                                              @RequestParam(defaultValue = "false") Boolean reported,
                                                              @RequestParam(defaultValue = "1") int filmType,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size) throws Exception {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "publicationDateTime"));
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.getAllCommentsByUserIdAndReportedAndFilmType(UUID.fromString(userId), reported, filmType, pageable));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/comments/films/{filmId}")
    ResponseEntity<Map<String, Object>> getCommentByFilmIdAndUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId,
                                                                    @PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId,
                                                                    @RequestParam(defaultValue = "false") String reported) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.getCommentByFilmIdAndUserId(UUID.fromString(filmId), UUID.fromString(userId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/films/{id}/comments")
    ResponseEntity<Map<String, Object>> getAllCommentByFilmIdAndRatingOrderByField(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                                                   @RequestParam(defaultValue = "false") Boolean reported,
                                                                                   @RequestParam(defaultValue = "all") String rating,
                                                                                   @RequestParam(defaultValue = "publicationDateTime") String order,
                                                                                   @RequestParam(defaultValue = "0") int page,
                                                                                   @RequestParam(defaultValue = "15") int size) throws Exception {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, order));
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.getAllCommentByFilmIdAndRatingOrderByField(UUID.fromString(id), reported, rating, pageable));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/films/{id}/comments/ratings")
    ResponseEntity<Map<String, Object>> getTotalRatingByFilmId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                               @RequestParam(defaultValue = "false") Boolean reported) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.getTotalRatingByFilmId(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/comments/{id}")
    ResponseEntity<Map<String, Object>> updateComment(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                      @RequestBody @Valid UpdateCommentDto updateCommentDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.updateComment(UUID.fromString(id), updateCommentDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    ResponseEntity<String> deleteComment(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        commentService.deleteComment(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Comment: " + id + " deleted successfully");
    }
}