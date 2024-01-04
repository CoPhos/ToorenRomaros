package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.services.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    ResponseEntity<Map<String, Object>> createImage(@RequestParam("image") @NotNull MultipartFile file,
                                                    @RequestParam("imageType") @NotNull String imageType,
                                                    @PathVariable @NotNull String ownerType,
                                                    @PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
            Map<String, Object> response = new HashMap<>();
            response.put("created", imageService.uploadImage(file, id, ownerType, imageType));
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/images/{id}")
    ResponseEntity<?> getImageFromFileSystem(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        byte[] imageBytes = imageService.getImageById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setCacheControl(CacheControl.maxAge(3600, TimeUnit.SECONDS));
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
    @GetMapping("/{ownerType}/images")
    ResponseEntity<Map<String, Object>> getAllImagesFromOwnerByIdSizeOwnertype(@RequestParam @NotNull @Pattern(regexp = uuidRegExp) String ownerId,
                                                                       @RequestParam @NotNull String type,
                                                                       @RequestParam(defaultValue = "desktop") String size,
                                                                       @PathVariable @NotNull String ownerType) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", imageService.getAllImagesByOwnerIdTypeSizeOwnerType(ownerId, type, size, ownerType));
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @GetMapping(value = "/{ownerType}/mainImage")
    ResponseEntity<?> getImageFromFileSystemByOwnerIdTypeSizeOwnerType(@RequestParam @NotNull @Pattern(regexp = uuidRegExp) String ownerId,
                                                                               @RequestParam @NotNull String type,
                                                                               @RequestParam(defaultValue = "desktop") String size,
                                                                               @PathVariable @NotNull String ownerType) throws Exception {
        byte[] imageBytes = imageService.getImageByOwnerIdTypeSizeOwnerType(ownerId, type, size, ownerType);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
}
