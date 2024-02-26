package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.staff.CreateStaffFilmDto;
import com.ToorenRomaros.api.dto.staff.GetStaffFilmDto;
import com.ToorenRomaros.api.dto.streamSite.CreateStreamSiteFilmDto;
import com.ToorenRomaros.api.dto.streamSite.GetStreamSiteFilmDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.StreamSiteFilmService;
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
@Tag(name = "Stream site", description = "Contains Stream site Entity Related Operations.")
@Tag(name = "Film", description = "Contains Film Entity Related Operations.")
public class StreamSiteFilmController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final StreamSiteFilmService streamSiteFilmService;
    public StreamSiteFilmController(StreamSiteFilmService streamSiteFilmService) {
        this.streamSiteFilmService = streamSiteFilmService;
    }

    @Operation(
            summary = "Create Film-Streaming Site Relationship",
            description = "This endpoint allows users to create a new relationship between a film and a streaming site by providing the necessary details using the provided payload.",
            tags = { "Stream site", "Film", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = GetStreamSiteFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "CreateStreamSiteFilmDto", description = "CreateStreamSiteFilmDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateStreamSiteFilmDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PostMapping("/streaming/film")
    ResponseEntity<Map<String, Object>> createStreamSiteFilm(@RequestBody @Valid CreateStreamSiteFilmDto createStreamSiteFilmDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", streamSiteFilmService.createStreamSiteFilm(createStreamSiteFilmDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get All Streaming sites From a Specific Film",
            description = "This endpoint retrieves all entities of the Film-Streaming relationship for a specific film identified by its unique identifier (filmId).",
            tags = { "Stream site", "Film", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetStreamSiteFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "ID of the Film", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/films/{filmId}/streamingsites")
    ResponseEntity<Map<String, Object>> getStreamSiteFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", streamSiteFilmService.getStreamSitesByFilmId(UUID.fromString(filmId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Operation(
            summary = "Delete Film-Streaming Relationship",
            description = "This endpoint allows users to delete a specific film-Streaming relationship identified by its unique identifier (relationshipId). Deleting a relationship is a permanent action and cannot be undone.",
            tags = { "Stream site", "Film", "delete" })
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
    @DeleteMapping("/streaming/film/{relationshipId}")
    ResponseEntity<String> deleteStreamSiteFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String relationshipId) {
        streamSiteFilmService.deleteStreamSiteFilm(UUID.fromString(relationshipId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Stream site from Film: " + relationshipId + " deleted successfully");
    }
}
