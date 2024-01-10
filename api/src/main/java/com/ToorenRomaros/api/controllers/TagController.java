package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.publication.CommentDto;
import com.ToorenRomaros.api.dto.tag.TagDto;
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
    ResponseEntity<Map<String, Object>> createTag(@RequestBody @Valid TagDto tagDto) throws Exception {
        TagDto newTag = tagService.createTag(tagDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newTag);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/tags/{id}")
    ResponseEntity<Map<String, Object>> updateTag(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                      @RequestBody TagDto tagDto) throws Exception {
        TagDto updatedTag = tagService.updateTag(UUID.fromString(id),tagDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedTag);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/tags/{id}")
    ResponseEntity<String>  deleteTag(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        tagService.deleteTag(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Tag: " + id + " deleted successfully");
    }
}
