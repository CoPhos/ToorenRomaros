package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.UpdateFilmDto;
import com.ToorenRomaros.api.dto.genre.CreateGenreFilmDto;
import com.ToorenRomaros.api.dto.genre.GetGenreFilmDto;
import com.ToorenRomaros.api.dto.media.CreateImageDto;
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
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Operation(
            summary = "Create Image for Film",
            description = "This endpoint allows users to add a new image to the file system for a specific film. Users can upload an image file, specify the image type, and provide the film ID.",
            tags = { "Image", "Film", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "CreateImageDto", description = "CreateImageDto object", required = true,
                    content = @Content(mediaType = "form-data",
                            schema = @Schema(implementation = CreateImageDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PostMapping("/film/images")
    ResponseEntity<Map<String, Object>> createImage(@RequestParam("image") @NotNull MultipartFile file,
                                                    @RequestParam("imageType") @NotNull String imageType,
                                                    @RequestParam @NotNull @Pattern(regexp = uuidRegExp) String filmId) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", imageService.uploadImage(file, filmId, imageType));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
