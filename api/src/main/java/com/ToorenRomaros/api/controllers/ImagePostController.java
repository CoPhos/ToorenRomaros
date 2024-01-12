package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.services.ImageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ImagePostController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final ImageService imageService;
    public ImagePostController(@Qualifier("ImageServicePostImpl") ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/posts/images")
    ResponseEntity<Map<String, Object>> createImage(@RequestParam("image") @NotNull MultipartFile file,
                                                    @RequestParam("imageType") @NotNull String imageType,
                                                    @RequestParam @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("created", imageService.uploadImage(file, id, imageType));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
