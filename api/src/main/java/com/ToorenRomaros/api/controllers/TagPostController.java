package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.tag.TagDto;
import com.ToorenRomaros.api.dto.tag.TagPostDto;
import com.ToorenRomaros.api.services.TagPostService;
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
public class TagPostController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final TagPostService tagPostService;

    public TagPostController(TagPostService tagPostService) {
        this.tagPostService = tagPostService;
    }

    @PostMapping("/posts/tags")
    ResponseEntity<Map<String, Object>> createTagPost(@RequestBody @Valid TagPostDto tagPostDto) throws Exception {
        TagPostDto newTagPost = tagPostService.createTagPost(tagPostDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newTagPost);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/posts/tags/{id}")
    ResponseEntity<Map<String, Object>> updateTagPost(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                  @RequestBody TagPostDto tagPostDto) throws Exception {
        TagPostDto updatedTagPost = tagPostService.updateTagPost(UUID.fromString(id), tagPostDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedTagPost);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/posts/tags/{id}")
    ResponseEntity<String>  deleteTagPost(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        tagPostService.deleteTagPost(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Tag: " + id + " deleted successfully");
    }
}
