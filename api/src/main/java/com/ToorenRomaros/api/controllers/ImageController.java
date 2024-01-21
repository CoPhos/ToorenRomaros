package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.services.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/v1")
public class ImageController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final ImageService imageService;
    private static final Logger log = LoggerFactory.getLogger(ImageController.class);
    public ImageController(@Qualifier("ImageServiceDefaultImpl") ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/images/{id}")
    ResponseEntity<?> getImageFromFileSystem(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        byte[] imageBytes = imageService.getImageById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setCacheControl(CacheControl.maxAge(3600, TimeUnit.SECONDS));
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
    @GetMapping("{ownerId}/media/images")
    ResponseEntity<?> getImagesIdByImageType(@RequestParam @NotNull String imageType, @PathVariable @NotNull String ownerId) throws Exception {
        return new ResponseEntity<>(imageService.getImageByImageType(imageType, ownerId), HttpStatus.OK);
    }
    @GetMapping("films/{id}/staffs/media/images")
    ResponseEntity<?> getAllImagesFromStaffByImageTypeAndFilmid(@RequestParam @NotNull String imageType, @PathVariable @NotNull String id) throws Exception {
        return new ResponseEntity<>(imageService.getAllImagesFromStaffByImageTypeAndFilmid(imageType, id), HttpStatus.OK);
    }

    @GetMapping("films/{id}/streamsites/media/images")
    ResponseEntity<?> getAllImagesFromStreamSiteByImageTypeAndStreamSiteId(@RequestParam @NotNull String imageType, @PathVariable @NotNull String id) throws Exception {
        return new ResponseEntity<>(imageService.getAllImagesFromStreamSiteByImageTypeAndStreamSiteId(imageType, id), HttpStatus.OK);
    }
}
