package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.CreateFilmDto;
import com.ToorenRomaros.api.dto.film.GetDynamicQyeryFilmDto;
import com.ToorenRomaros.api.dto.film.GetFilmDto;
import com.ToorenRomaros.api.dto.film.UpdateFilmDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.FilmService;
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
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@Tag(name = "Film", description = "Contains Film Entity Related Operations.")
public class FilmController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final FilmService filmService;
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }


    @Operation(
            summary = "Create Film",
            description = "This endpoint allows users to create a new film by providing the necessary details using the provided payload.",
            tags = { "Film", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = GetFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "createFilmDto", description = "createFilmDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateFilmDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PostMapping("/films")
    ResponseEntity<Map<String, Object>> createFilm(@RequestBody @Valid CreateFilmDto createFilmDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", filmService.createFilm(createFilmDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Film by ID",
            description = "This endpoint retrieves a specific film identified by its unique identifier (ID).",
            tags = { "Film", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "ID of the Film", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/films/{filmId}")
    ResponseEntity<Map<String, Object>> getFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", filmService.getFilmById(UUID.fromString(filmId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Film by ID",
            description = "This endpoint retrieves a specific film identified by its unique identifier (ID).",
            tags = { "Film", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetDynamicQyeryFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "streamId", description = "List of stream IDs to filter films by.", in = ParameterIn.QUERY),
            @Parameter(name = "genres", description = "List of genres to filter films by.", in = ParameterIn.QUERY),
            @Parameter(name = "suitableFor", description = "List of suitability factors to filter films by.", example = "[PG,PG-18]", in = ParameterIn.QUERY),
            @Parameter(name = "filmType", description = "Filter films by type (e.g., \"all\", \"1\", \"2\"). Default is \"all\". (1 is for movies, 2 is for series).", in = ParameterIn.QUERY),
            @Parameter(name = "atTheaters", description = "Filter films currently at theaters or not. Default is \"false\".", in = ParameterIn.QUERY),
            @Parameter(name = "commingSoonStreaming", description = "Filter films coming soon on streaming platforms or not. Default is \"false\".", in = ParameterIn.QUERY),
            @Parameter(name = "atStreaming", description = "Filter films currently streaming or not. Default is \"false\".", in = ParameterIn.QUERY),
            @Parameter(name = "orderBy", description = "Array of fields for sorting films. Default is [\"tittle-asc\"]", example = "[title-asc, releaseDate-desc]",in = ParameterIn.QUERY),
            @Parameter(name = "userRating", description = "Filter films by user rating. \"down\" for ratings less than 60 otherwise \"up\"", in = ParameterIn.QUERY),
            @Parameter(name = "superRating", description = "Filter films by super rating. \"down\" for ratings less than 60 otherwise \"up\"", in = ParameterIn.QUERY),
            @Parameter(name = "search", description = " Perform a search query to filter films by title.", in = ParameterIn.QUERY),
            @Parameter(name = "page", description = "The number page of the request.", in = ParameterIn.QUERY),
            @Parameter(name = "size", description = "The page size of each request. Default is \"6\"", in = ParameterIn.QUERY),
    })
    @GetMapping("/films")
    ResponseEntity<Map<String, Object>> getFilmByDynamicQuery(@RequestParam(required = false) List<String> streamId,
                                                              @RequestParam(required = false) List<String> genres,
                                                              @RequestParam(required = false) List<String> suitableFor,
                                                              @RequestParam(defaultValue = "all") String filmType,
                                                              @RequestParam(required = false) String atTheaters,
                                                              @RequestParam(required = false) String commingSoonStreaming,
                                                              @RequestParam(required = false) String commingSoonTheaters,
                                                              @RequestParam(required = false) String atStreaming,
                                                              @RequestParam(defaultValue = "tittle-asc") String[] orderBy,
                                                              @RequestParam(required = false) String userRating,
                                                              @RequestParam(required = false) String superRating,
                                                              @RequestParam(required = false) String search,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "6") int size) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> films = filmService.getFilmByDynamicQuery(streamId, genres, suitableFor, filmType,
                atTheaters, atStreaming, commingSoonStreaming, commingSoonTheaters, orderBy, userRating, superRating, search, page, size);
        response.put("response", films.get("queryResult"));
        response.put("currentPage", films.get("pageNumber"));
        response.put("pageSize", films.get("pageSize"));
        response.put("maxResults", films.get("maxResults"));
        response.put("totalPages", films.get("totalPages"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Film by ID",
            description = "This endpoint retrieves all films associated with a specific saga identified by its unique identifier (ID).",
            tags = { "Film", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "sagaId", description = "ID of the Saga", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("sagas/{sagaId}/films")
    ResponseEntity<Map<String, Object>> getAllFilmBySagaId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String sagaId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", filmService.getAllFilmsBySagaId(UUID.fromString(sagaId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Film",
            description = "This endpoint allows users to update a specific film identified by its unique identifier (ID). Users can modify the properties of the film using the provided update payload.",
            tags = { "Film", "patch" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "ID of the Film", required = true, in = ParameterIn.PATH),
            @Parameter(name = "updateFilmDto", description = "updateFilmDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UpdateFilmDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PatchMapping("/films/{filmId}")
    ResponseEntity<Map<String, Object>> updateFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId, @RequestBody @Valid UpdateFilmDto updateFilmDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", filmService.updateFilm(UUID.fromString(filmId), updateFilmDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Film",
            description = "This endpoint allows users to delete a specific film identified by its unique identifier (filmId). Deleting a film is a permanent action and cannot be undone.",
            tags = { "Film", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "The ID of the Film", required = true, in = ParameterIn.PATH),
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @DeleteMapping("/films/{filmId}")
    ResponseEntity<String> deleteFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId) {
        filmService.deleteFilm(UUID.fromString(filmId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Film: " + filmId + " deleted successfully");
    }
}
