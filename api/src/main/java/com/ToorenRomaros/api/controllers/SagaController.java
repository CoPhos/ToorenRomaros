package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.CreateFilmDto;
import com.ToorenRomaros.api.dto.film.GetFilmDto;
import com.ToorenRomaros.api.dto.film.SagaDto;
import com.ToorenRomaros.api.dto.film.UpdateFilmDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.SagaService;
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
@Tag(name = "Saga", description = "Contains Saga Entity Related Operations.")
public class SagaController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final SagaService sagaService;
    public SagaController(SagaService sagaService) {
        this.sagaService = sagaService;
    }

    @Operation(
            summary = "Create Saga",
            description = "This endpoint allows users to create a new saga by providing the necessary details using the provided payload.",
            tags = { "Saga", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = SagaDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "SagaDto", description = "SagaDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SagaDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PostMapping("/sagas")
    ResponseEntity<Map<String, Object>> createSaga(@RequestBody @Valid SagaDto sagaDto){
        Map<String, Object> response = new HashMap<>();
        response.put("response", sagaService.createSaga(sagaDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Saga by ID",
            description = "This endpoint retrieves a specific saga identified by its unique identifier (id).",
            tags = { "Saga", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetFilmDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "sagaId", description = "ID of the Saga", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/sagas/{sagaId}")
    ResponseEntity<Map<String, Object>> getSaga(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String sagaId){
        Map<String, Object> response = new HashMap<>();
        response.put("response", sagaService.getSagaById(UUID.fromString(sagaId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Operation(
            summary = "Update Saga",
            description = "This endpoint allows users to update a specific saga entity identified by its unique identifier (sagaId). Users can modify the properties of the saga using the provided update payload.",
            tags = { "Saga", "patch" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SagaDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "sagaId", description = "ID of the Saga", required = true, in = ParameterIn.PATH),
            @Parameter(name = "SagaDto", description = "SagaDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SagaDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PatchMapping("/sagas/{sagaId}")
    ResponseEntity<Map<String, Object>> updateSaga(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String sagaId, @RequestBody @Valid SagaDto sagaDto){
        Map<String, Object> response = new HashMap<>();
        response.put("response", sagaService.updateSaga(UUID.fromString(sagaId), sagaDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Operation(
            summary = "Delete Saga",
            description = "This endpoint allows users to delete a specific saga identified by its unique identifier (id). Deleting a saga is a permanent action and cannot be undone.",
            tags = { "Saga", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "sagaId", description = "The ID of the Saga", required = true, in = ParameterIn.PATH),
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = {"ADMIN"})
    @DeleteMapping("/sagas/{sagaId}")
    ResponseEntity<String> deleteSaga(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String sagaId){
        sagaService.deleteSaga(UUID.fromString(sagaId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Saga: " + sagaId + " deleted successfully");
    }
}