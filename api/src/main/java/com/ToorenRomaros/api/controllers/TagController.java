package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.staff.CreateStaffDto;
import com.ToorenRomaros.api.dto.staff.GetStaffDto;
import com.ToorenRomaros.api.dto.staff.UpdateStaffDto;
import com.ToorenRomaros.api.dto.tag.CreateTagDto;
import com.ToorenRomaros.api.dto.tag.GetTagDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.TagService;
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
@Tag(name = "Tag", description = "Contains Tag Entity Related Operations.")
public class TagController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @Operation(
            summary = "Create Tag",
            description = "This endpoint allows users to create a new Tag by providing the necessary details using the provided payload.",
            tags = { "Tag", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = CreateTagDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "GetTagDto", description = "GetTagDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetTagDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PostMapping("/tags")
    ResponseEntity<Map<String, Object>> createTag(@RequestBody @Valid CreateTagDto createTagDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", tagService.createTag(createTagDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Operation(
            summary = "Update Tag",
            description = "This endpoint allows users to update a specific Tag entity identified by its unique identifier (staffId). Users can modify the properties of the Tag using the provided update payload.",
            tags = { "Staff", "patch" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetTagDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "tagId", description = "ID of the Tag", required = true, in = ParameterIn.PATH),
            @Parameter(name = "CreateTagDto", description = "CreateTagDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateTagDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PutMapping("/tags/{tagId}")
    ResponseEntity<Map<String, Object>> updateTag(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                      @RequestBody CreateTagDto createTagDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", tagService.updateTag(UUID.fromString(id), createTagDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Operation(
            summary = "Delete Tag",
            description = "This endpoint allows users to delete a specific Tag identified by its unique identifier (id). Deleting a Tag is a permanent action and cannot be undone.",
            tags = { "Tag", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "tagId", description = "The ID of the Tag", required = true, in = ParameterIn.PATH),
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = {"ADMIN"})
    @DeleteMapping("/tags/{tagId}")
    ResponseEntity<String>  deleteTag(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String tagId) {
        tagService.deleteTag(UUID.fromString(tagId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Tag: " + tagId + " deleted successfully");
    }
}
