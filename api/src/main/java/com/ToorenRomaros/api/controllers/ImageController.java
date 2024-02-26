package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.genre.CreateGenreFilmDto;
import com.ToorenRomaros.api.dto.media.GetListImagesDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/v1")
@Tag(name = "Image", description = "Contains Image Entity Related Operations.")
public class ImageController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final ImageService imageService;
    public ImageController(@Qualifier("ImageServiceDefaultImpl") ImageService imageService) {
        this.imageService = imageService;
    }

    @Operation(
            summary = "Get Image by ID",
            description = "This endpoint retrieves an image identified by its unique identifier (imageId) from the file system.",
            tags = { "Image", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(
                    mediaType = "application/octet-stream",
                    schema = @Schema(type = "string", format = "binary")
            )),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "imageId", description = "ID of the Image", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/images/{imageId}")
    ResponseEntity<?> getImageFromFileSystem(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String imageId) throws Exception {
        byte[] imageBytes = imageService.getImageById(imageId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setCacheControl(CacheControl.maxAge(3600, TimeUnit.SECONDS));
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Images by Image Type and Owner ID",
            description = "This endpoint retrieves all images associated with a specific entity (ownerId) and a specified image type.",
            tags = { "Image", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetListImagesDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "ownerId", description = "The unique identifier of the entity (e.g., user, film) owning the images.", required = true, in = ParameterIn.PATH),
            @Parameter(name = "imageType ", description = "The type of images to filter (e.g., \"USER_PROFILE\", \"FILM_COLLECTION\").", required = true, in = ParameterIn.QUERY)
    })
    @GetMapping("{ownerId}/media/images")
    ResponseEntity<?> getAllImagesIdByImageTypeAndOwnerId(@RequestParam @NotNull String imageType, @PathVariable @NotNull String ownerId) {
        return new ResponseEntity<>(imageService.getImageByImageType(imageType, ownerId), HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Images from Staff by Image Type and Film ID",
            description = "This endpoint retrieves all images associated with staff members (owners) that appear in a specific film (identified by film ID) and filter by a specified image type.",
            tags = { "Image", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetListImagesDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "The ID of the Film.", required = true, in = ParameterIn.PATH),
            @Parameter(name = "imageType ", description = "The type of images to filter (e.g., \"USER_PROFILE\", \"FILM_COLLECTION\").", required = true, in = ParameterIn.QUERY)
    })
    @GetMapping("films/{filmId}/staffs/media/images")
    ResponseEntity<?> getAllImagesFromStaffByImageTypeAndFilmid(@RequestParam @NotNull String imageType, @PathVariable @NotNull String id) {
        return new ResponseEntity<>(imageService.getAllImagesFromStaffByImageTypeAndFilmid(imageType, id), HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Images from Streamsite by Image Type and Film ID",
            description = "This endpoint retrieves all images associated with a streamsite (owner) that appear in a specific film (identified by film ID) and filters by a specified image type.",
            tags = { "Image", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetListImagesDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "The ID of the Film.", required = true, in = ParameterIn.PATH),
            @Parameter(name = "imageType ", description = "The type of images to filter (e.g., \"USER_PROFILE\", \"FILM_COLLECTION\").", required = true, in = ParameterIn.QUERY)
    })
    @GetMapping("films/{imageId}/streamsites/media/images")
    ResponseEntity<?> getAllImagesFromStreamSiteByImageTypeAndStreamSiteId(@RequestParam @NotNull String imageType, @PathVariable @NotNull String id) {
        return new ResponseEntity<>(imageService.getAllImagesFromStreamSiteByImageTypeAndStreamSiteId(imageType, id), HttpStatus.OK);
    }
}
