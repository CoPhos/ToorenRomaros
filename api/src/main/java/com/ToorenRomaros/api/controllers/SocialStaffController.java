package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.socials.SocialDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericAddRequestDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;
import com.ToorenRomaros.api.services.SocialGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class SocialStaffController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";

    private final SocialGenericService socialGenericService;
    public SocialStaffController(@Qualifier("SocialGenericStaffServiceImpl") SocialGenericService socialGenericService) {
        this.socialGenericService = socialGenericService;
    }

    @PostMapping("/socials/staffs")
    ResponseEntity<Map<String, Object>> createSocialsStaff(@RequestBody @Valid SocialGenericAddRequestDto socialGenericAddRequestDto) throws Exception {
        SocialGenericDto newSocial = socialGenericService.createSocialGeneric(socialGenericAddRequestDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newSocial);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
