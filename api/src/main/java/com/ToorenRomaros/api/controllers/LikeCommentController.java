package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.publication.CreateLikeDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class LikeCommentController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final LikeService likeService;

    public LikeCommentController(@Qualifier("LikeServiceCommentImpl") LikeService likeService) {
        this.likeService = likeService;
    }

    @Operation(
            summary = "Create Like-Comment Relationship",
            description = "This endpoint allows users to increment like count for a specific comment. Users can specify the comment ID and user ID in the payload to establish the relationship.",
            tags = { "Like", "Post", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = CreateLikeDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "createLikeDto", description = "createLikeDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateLikeDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "USER")
    @PostMapping("/comments/likes")
    ResponseEntity<String> createLike(@RequestBody @Valid CreateLikeDto createLikeDto) {
       likeService.addLike(createLikeDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Created");
    }

    @Operation(
            summary = "Delete Like-Comment Relationship",
            description = "This endpoint allows users to delete a specific like-comment relationship identified by the user ID and the resource ID. Deleting a relationship is a permanent action and cannot be undone.",
            tags = { "Like", "Comment", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "owner", description = "The ID of the comment", in = ParameterIn.QUERY),
            @Parameter(name = "user", description = "The ID of the user", in = ParameterIn.QUERY),
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "USER, CRITIC")
    @DeleteMapping("/comments/likes")
    ResponseEntity<String> deleteLike(@RequestParam @NotNull @Pattern(regexp = uuidRegExp) UUID owner,
                                      @RequestParam @NotNull @Pattern(regexp = uuidRegExp)  UUID user) {
        likeService.removeLike(owner, user);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Like deleted successfully");
    }
}
