package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.services.ImageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ImageFilmController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final ImageService imageService;
    public ImageFilmController(@Qualifier("ImageServiceFilmImpl") ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/film/images")
    ResponseEntity<Map<String, Object>> createImage(@RequestParam("image") @NotNull MultipartFile file,
                                                    @RequestParam("imageType") @NotNull String imageType,
                                                    @RequestParam @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", imageService.uploadImage(file, id, imageType));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
