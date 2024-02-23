package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.tag.CreateTagDto;
import com.ToorenRomaros.api.services.TagService;
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
public class TagController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/tags")
    ResponseEntity<Map<String, Object>> createTag(@RequestBody @Valid CreateTagDto createTagDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", tagService.createTag(createTagDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/tags/{id}")
    ResponseEntity<Map<String, Object>> updateTag(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                      @RequestBody CreateTagDto createTagDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", tagService.updateTag(UUID.fromString(id), createTagDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/tags/{id}")
    ResponseEntity<String>  deleteTag(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        tagService.deleteTag(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Tag: " + id + " deleted successfully");
    }
}
