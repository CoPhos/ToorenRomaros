package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.services.ImageService;
import com.ToorenRomaros.api.services.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ImageController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final ImageService imageService;
    private static final Logger log = LoggerFactory.getLogger(ImageController.class);
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/{ownerType}/{id}/image")
    ResponseEntity<Map<String, Object>> createImage(@RequestParam("image") MultipartFile file,
                                                    @RequestParam("imageSize") String imageSize,
                                                    @RequestParam("imageType") String imageType,
                                                    @PathVariable String ownerType,
                                                    @PathVariable String id) throws Exception {
            Map<String, Object> response = new HashMap<>();
            response.put("created", imageService.uploadImageToFileSystem(file, imageSize, id, ownerType, imageType));
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/users/{id}/profileImage")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String id, @RequestParam(defaultValue = "small") String size) throws Exception {
        byte[] imageBytes = imageService.getProfileImageFromFileSystem(id, size);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);

    }
}
