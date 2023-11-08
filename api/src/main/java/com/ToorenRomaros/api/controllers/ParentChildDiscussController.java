package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.publication.DiscussDto;
import com.ToorenRomaros.api.dto.publication.ParentChildDiscussDto;
import com.ToorenRomaros.api.services.ParentChildDiscussService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ParentChildDiscussController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";

    private final ParentChildDiscussService parentChildDiscussService;

    public ParentChildDiscussController(ParentChildDiscussService parentChildDiscussService) {
        this.parentChildDiscussService = parentChildDiscussService;
    }

    @PostMapping("/subDiscuss")
    ResponseEntity<Map<String, Object>> createComment(@RequestBody @Valid ParentChildDiscussDto parentChildDiscussDto) throws Exception {
        ParentChildDiscussDto newSubDiscuss = parentChildDiscussService.createSubDiscuss(parentChildDiscussDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newSubDiscuss);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
