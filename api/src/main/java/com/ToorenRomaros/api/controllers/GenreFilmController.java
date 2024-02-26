package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.genre.CreateGenreFilmDto;
import com.ToorenRomaros.api.dto.genre.GenreDto;
import com.ToorenRomaros.api.dto.genre.GetGenreFilmDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.GenreFilmService;
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
import io.swagger.v3.oas.annotations.tags.Tags;
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
@Tag(name = "Film", description = "Contains Film Entity Related Operations.")
public class GenreFilmController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final GenreFilmService genreFilmService;

    public GenreFilmController(GenreFilmService genreFilmService) {
        this.genreFilmService = genreFilmService;
    }

    @Operation(
            summary = "Create Film-Genre Relationship",
            description = "This endpoint allows users to create a new relationship between a film and its corresponding genre. Users can specify the film ID and genre ID in the payload to establish the relationship.",
            tags = { "Genre", "Film", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = CreateGenreFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "getGenreFilmDto", description = "getGenreFilmDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetGenreFilmDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PostMapping("/films/genres")
    ResponseEntity<Map<String, Object>> createFilmGenre(@RequestBody @Valid CreateGenreFilmDto createGenreFilmDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response",  genreFilmService.createGenreFilm(createGenreFilmDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get All Genres From a Specific Film",
            description = "This endpoint retrieves all entities of the film-genre relationship for a specific film identified by its unique identifier (filmId).",
            tags = { "Genre", "Film", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CreateGenreFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "ID of the Film", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/films/{filmId}/genres")
    ResponseEntity<Map<String, Object>> getFilmGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", genreFilmService.getGenreFilm(UUID.fromString(filmId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Film-Genre Relationship",
            description = "This endpoint allows users to update a film-genre relationship by its unique identifier (relationshipId). Users can modify the genre associated with the film using the provided update payload.",
            tags = { "Genre", "Film", "patch" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CreateGenreFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "relationshipId", description = "ID of the Relationship", required = true, in = ParameterIn.PATH),
            @Parameter(name = "GetGenreFilmDto", description = "GetGenreFilmDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetGenreFilmDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PatchMapping("/films-genres/{relationshipId}")
    ResponseEntity<Map<String, Object>> updateFilmGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String relationshipId, @RequestBody @Valid CreateGenreFilmDto createGenreFilmDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", genreFilmService.updateGenreFilm(UUID.fromString(relationshipId), createGenreFilmDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Film-Genre Relationship",
            description = "This endpoint allows users to delete a specific film-genre relationship identified by its unique identifier (relationshipId). Deleting a relationship is a permanent action and cannot be undone.",
            tags = { "Genre", "Film", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "relationshipId", description = "The ID of the Relationship", required = true, in = ParameterIn.PATH),
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @DeleteMapping("/films-genres/{relationshipId}")
    ResponseEntity<String> deleteFilmGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String relationshipId) {
        genreFilmService.deleteGenreFilm(UUID.fromString(relationshipId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Relationship: " + relationshipId + " deleted successfully");
    }
}
