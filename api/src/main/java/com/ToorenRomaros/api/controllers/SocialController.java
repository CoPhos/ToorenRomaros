package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.socials.SocialDto;
import com.ToorenRomaros.api.dto.staff.StaffDto;
import com.ToorenRomaros.api.services.SocialService;
import com.ToorenRomaros.api.services.StaffService;
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
public class SocialController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final SocialService socialService;

    public SocialController(SocialService socialService) {
        this.socialService = socialService;
    }

    @PostMapping("/socials")
    ResponseEntity<Map<String, Object>> createSocial(@RequestBody @Valid SocialDto socialDto) throws Exception {
        SocialDto newSocial = socialService.createSocial(socialDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newSocial);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/socials/{id}")
    ResponseEntity<Map<String, Object>> getSocial(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        SocialDto social = socialService.getSocialById(UUID.fromString(id));
        Map<String, Object> response = new HashMap<>();
        response.put("response", social);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/socials/{id}")
    ResponseEntity<Map<String, Object>> updateSocial(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody SocialDto socialDto) throws Exception {
        SocialDto updateSocial = socialService.updateSocial(UUID.fromString(id), socialDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updateSocial);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/socials/{id}")
    ResponseEntity<String> deleteSocial(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        socialService.deleteSocialByid(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Social: " + id + " deleted successfully");
    }
}
