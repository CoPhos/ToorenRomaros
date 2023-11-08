package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.publication.CommentDto;
import com.ToorenRomaros.api.dto.publication.DiscussDto;
import com.ToorenRomaros.api.services.DiscussService;
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
public class DiscussController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final DiscussService discussService;

    public DiscussController(DiscussService discussService) {
        this.discussService = discussService;
    }

    @PostMapping("/discuss")
    ResponseEntity<Map<String, Object>> createComment(@RequestBody @Valid DiscussDto discussDto) throws Exception {
        DiscussDto newDiscuss = discussService.createDiscuss(discussDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newDiscuss);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}/discuss")
    ResponseEntity<Map<String, Object>> getAllCommentByFilmId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                              @RequestParam(defaultValue = "false") Boolean reported) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", discussService.getAllDiscussByPostId(UUID.fromString(id), reported));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/discuss/{id}/subDiscuss")
    ResponseEntity<Map<String, Object>> getAllChildDiscussByParentDiscussId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                              @RequestParam(defaultValue = "false") Boolean reported) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", discussService.getAllChildDiscussFromParentDiscussId(UUID.fromString(id), reported));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/discuss/{id}")
    ResponseEntity<Map<String, Object>> updateComment(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                      @RequestBody DiscussDto discussDto) throws Exception {
        DiscussDto updatedDiscuus = discussService.updateDiscuus(UUID.fromString(id),discussDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedDiscuus);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/discuss/{id}")
    ResponseEntity<String>  deleteComment(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        discussService.deleteDiscuss(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Discuss: " + id + " deleted successfully");
    }


}
