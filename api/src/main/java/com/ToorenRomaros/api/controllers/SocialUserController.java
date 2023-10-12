package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.socials.SocialGenericAddRequestDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;
import com.ToorenRomaros.api.services.SocialGenericService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class SocialUserController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";

    private final SocialGenericService socialGenericService;
    public SocialUserController(@Qualifier("SocialGenericUserServiceImpl") SocialGenericService socialGenericService) {
        this.socialGenericService = socialGenericService;
    }

    @PostMapping("/socials/users/{username}")
    ResponseEntity<Map<String, Object>> createSocialsUser(@RequestBody @Valid SocialGenericAddRequestDto socialGenericAddRequestDto, @PathVariable String username) throws Exception {
        SocialGenericDto newSocial = socialGenericService.createSocialGeneric(socialGenericAddRequestDto, username);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newSocial);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/socials/users/{username}/{id}")
    ResponseEntity<Map<String, Object>> getSocialById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        List<SocialGenericDto> social = socialGenericService.getSocialGenericById(UUID.fromString(id));
        Map<String, Object> response = new HashMap<>();
        response.put("response", social);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/socials/users/{username}/{id}")
    ResponseEntity<Map<String, Object>> updateSocialUser(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id , @PathVariable String username, @RequestBody SocialGenericAddRequestDto socialGenericAddRequestDto) throws Exception {
        SocialGenericDto updateSocialGeneric = socialGenericService.updateSocialGeneric(UUID.fromString(id), socialGenericAddRequestDto, username);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updateSocialGeneric);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/socials/users/{username}/{id}")
    ResponseEntity<String> deleteSocialUser(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @PathVariable String username) throws Exception {
        socialGenericService.deleteSocialGenericById(UUID.fromString(id), username);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Social: " + id + " deleted successfully");
    }
}
