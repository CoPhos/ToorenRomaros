package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.genre.CreateGenreFilmDto;
import com.ToorenRomaros.api.dto.genre.GetGenreFilmDto;
import com.ToorenRomaros.api.dto.staff.CreateStaffFilmDto;
import com.ToorenRomaros.api.dto.staff.GetStaffFilmDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.StaffFilmService;
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
@Tag(name = "Staff", description = "Contains Staff Entity Related Operations.")
@Tag(name = "Film", description = "Contains Film Entity Related Operations.")
public class StaffFilmController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final StaffFilmService staffFilmService;

    public StaffFilmController(StaffFilmService staffFilmService) {
        this.staffFilmService = staffFilmService;
    }

    @Operation(
            summary = "Create Film-Staff Relationship",
            description = "This endpoint allows users to create a new relationship between a film and a staff member by providing the necessary details using the provided payload.",
            tags = { "Staff", "Film", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = GetStaffFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "CreateStaffFilmDto", description = "CreateStaffFilmDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateStaffFilmDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PostMapping("/films/staffs")
    ResponseEntity<Map<String, Object>> createStaffFilm(@RequestBody @Valid CreateStaffFilmDto createStaffFilmDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", staffFilmService.addStaffFilm(createStaffFilmDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Operation(
            summary = "Get All Staff From a Specific Film",
            description = "This endpoint retrieves all entities of the film-Staff relationship for a specific film identified by its unique identifier (filmId).",
            tags = { "Staff", "Film", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetStaffFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "ID of the Film", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/films/{filmId}/staffs")
    ResponseEntity<Map<String, Object>> getStaffFilmByFilmId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", staffFilmService.getAllStaffFromFilm(UUID.fromString(filmId)));
        return new ResponseEntity<>(response, HttpStatus.OK);

    }


    @Operation(
            summary = "Delete Film-Staff Relationship",
            description = "This endpoint allows users to delete a specific film-Staff relationship identified by its unique identifier (relationshipId). Deleting a relationship is a permanent action and cannot be undone.",
            tags = { "Staff", "Film", "delete" })
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
    @DeleteMapping("/films/staffs/{relationshipId}")
    ResponseEntity<String> deleteStaffFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String relationshipId) {
        staffFilmService.deleteStaffFilm(UUID.fromString(relationshipId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Staff from film: " + relationshipId + " deleted successfully");
    }
}
