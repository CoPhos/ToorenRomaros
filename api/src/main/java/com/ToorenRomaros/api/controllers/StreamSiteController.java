package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.streamSite.CreateStreamSiteDto;
import com.ToorenRomaros.api.dto.streamSite.GetStreamSiteDto;
import com.ToorenRomaros.api.dto.streamSite.UpdateStreamSiteDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.StreamSiteService;
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
public class StreamSiteController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final StreamSiteService streamSiteService;

    public StreamSiteController(StreamSiteService streamSiteService) {
        this.streamSiteService = streamSiteService;
    }

    @Operation(
            summary = "Create Streaming Site",
            description = "This endpoint allows users to create a new Stream site by providing the necessary details using the provided payload.",
            tags = { "Stream site", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = CreateStreamSiteDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "GetStreamSiteDto", description = "GetStreamSiteDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetStreamSiteDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PostMapping("/streaming")
    ResponseEntity<Map<String, Object>> createStreamSite(@RequestBody @Valid CreateStreamSiteDto createStreamSiteDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", streamSiteService.createStreamSite(createStreamSiteDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Stream Site by ID",
            description = "This endpoint retrieves a specific Stream site identified by its unique identifier (id).",
            tags = { "Stream site", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetStreamSiteDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "streamsiteId", description = "ID of the Stream site", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/streaming/{streamsiteId}")
    ResponseEntity<Map<String, Object>> getStreamSite(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String streamsiteId) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", streamSiteService.getStreamSite(UUID.fromString(streamsiteId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Operation(
            summary = "Update Stream Site",
            description = "This endpoint allows users to update a specific Stream site entity identified by its unique identifier (streamsiteId). Users can modify the properties of the Stream site using the provided update payload.",
            tags = { "Stream site", "patch" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = UpdateStreamSiteDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "streamsiteId", description = "ID of the Stream site", required = true, in = ParameterIn.PATH),
            @Parameter(name = "GetStreamSiteDto", description = "GetStreamSiteDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetStreamSiteDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PatchMapping("/streaming/{streamsiteId}")
    ResponseEntity<Map<String, Object>> updateStreamSite(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String streamsiteId, @RequestBody @Valid UpdateStreamSiteDto createStreamSiteDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", streamSiteService.updateStreamSite(UUID.fromString(streamsiteId), createStreamSiteDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Operation(
            summary = "Delete Stream site",
            description = "This endpoint allows users to delete a specific Stream site identified by its unique identifier (id). Deleting a Stream site is a permanent action and cannot be undone.",
            tags = { "Stream site", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "streamsiteId", description = "The ID of the Stream site", required = true, in = ParameterIn.PATH),
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = {"ADMIN"})
    @DeleteMapping("/streaming/{streamsiteId}")
    ResponseEntity<String> deleteStreamSite(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String streamsiteId) throws Exception {
        streamSiteService.deleteStreamSite(UUID.fromString(streamsiteId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Stream site: " + streamsiteId + " deleted successfully");
    }
}
