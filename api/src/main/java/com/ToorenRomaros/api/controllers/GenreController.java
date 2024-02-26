package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.CreateFilmDto;
import com.ToorenRomaros.api.dto.film.GetFilmDto;
import com.ToorenRomaros.api.dto.film.UpdateFilmDto;
import com.ToorenRomaros.api.dto.genre.GenreDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.GenreService;
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
@Tag(name = "Genre", description = "Contains Genre Entity Related Operations.")
public class GenreController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @Operation(
            summary = "Create Genre",
            description = "This endpoint allows users to add a new genre by providing the necessary details using the provided payload.",
            tags = { "Genre", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = GenreDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "genreDto", description = "genreDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenreDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PostMapping("/genre")
    ResponseEntity<Map<String, Object>> createGenre(@RequestBody @Valid GenreDto genreDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", genreService.createGenre(genreDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Genre by ID",
            description = "This endpoint retrieves a specific genre identified by its unique identifier (ID).",
            tags = { "Genre", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GenreDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "genreId", description = "ID of the Genre", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/genre/{genreId}")
    ResponseEntity<Map<String, Object>> getGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String genreId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", genreService.getGenre(UUID.fromString(genreId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Genre by ID",
            description = "This endpoint allows users to update a specific genre identified by its unique identifier (genreId). Users can modify the properties of the genre using the provided update payload.",
            tags = { "Genre", "patch" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GenreDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "genreId", description = "ID of the Genre", required = true, in = ParameterIn.PATH),
            @Parameter(name = "genreDto", description = "genreDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenreDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PatchMapping("/genre/{genreId}")
    ResponseEntity<Map<String, Object>> updateGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String genreId, @RequestBody GenreDto genreDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", genreService.updateGenre(UUID.fromString(genreId), genreDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Genre by ID",
            description = "This endpoint allows users to delete a specific genre identified by its unique identifier (ID). Deleting a genre is a permanent action and cannot be undone.",
            tags = { "Genre", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "genreId", description = "The ID of the Genre", required = true, in = ParameterIn.PATH),
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @DeleteMapping("/genre/{genreId}")
    ResponseEntity<String> deleteGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String genreId) {
        genreService.deleteGenre(UUID.fromString(genreId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Genre: " + genreId + " deleted successfully");
    }
}
