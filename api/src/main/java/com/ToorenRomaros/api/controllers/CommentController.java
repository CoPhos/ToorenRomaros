package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.publication.CreateCommentDto;
import com.ToorenRomaros.api.dto.publication.GetCommentDto;
import com.ToorenRomaros.api.dto.publication.UpdateCommentDto;
import com.ToorenRomaros.api.dto.user.RecoverPasswordDto;
import com.ToorenRomaros.api.dto.user.SignInDto;
import com.ToorenRomaros.api.dto.user.UserSignedInDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.CommentService;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@Tag(name = "Comment", description = "Contains Comment Entity Related Operations.")
public class CommentController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @Operation(
            summary = "Create Comment for Film",
            description = "This endpoint allows users to create a comment for a specific film. Common Users can express their thoughts and opinions by providing a comment associated with the film identified by its unique identifier.",
            tags = { "Comment", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = GetCommentDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "createCommentDto", description = "createCommentDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateCommentDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "USER")
    @PostMapping("/comments")
    ResponseEntity<Map<String, Object>> createComment(@RequestBody @Valid CreateCommentDto createCommentDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.createComment(createCommentDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Comment by ID",
            description = "This endpoint retrieves a specific comment based on its unique identifier (ID). Users can query and view details of a comment associated with a film by providing the comment's ID.",
            tags = { "Comment", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetCommentDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "commentId", description = "ID of the comment", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/comments/{commentId}")
    ResponseEntity<Map<String, Object>> getCommentById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String commentId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.getCommentById(UUID.fromString(commentId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All User Comments",
            description = "This endpoint retrieves all comments associated with a specific user identified by their unique identifier (userId). Users can view the comments they have made on various films.",
            tags = { "Comment", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetCommentDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "userId", description = "ID of the user", required = true, in = ParameterIn.PATH),
            @Parameter(name = "reported", description = "Return comments flaged as reported or not", in = ParameterIn.QUERY),
            @Parameter(name = "filmType", description = "The type of film to search for", in = ParameterIn.QUERY),
            @Parameter(name = "page", description = "The number page of the request", in = ParameterIn.QUERY),
            @Parameter(name = "size", description = "The page size of each request", in = ParameterIn.QUERY),
    })
    @GetMapping("/users/{userId}/comments")
    ResponseEntity<Map<String, Object>> getAllCommentByUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId,
                                                              @RequestParam(defaultValue = "false") Boolean reported,
                                                              @RequestParam(defaultValue = "1") int filmType,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "publicationDateTime"));
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.getAllCommentsByUserIdAndReportedAndFilmType(UUID.fromString(userId), reported, filmType, pageable));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Comment by Film and User",
            description = "This endpoint retrieves a specific comment made by a user in a particular film. The comment is identified based on the unique identifiers of both the user (userId) and the film (filmId).",
            tags = { "Comment", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetCommentDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "userId", description = "ID of the user", required = true, in = ParameterIn.PATH),
            @Parameter(name = "filmId", description = "ID ofthe film", in = ParameterIn.PATH),
            @Parameter(name = "reported", description = "Filter comments based on whether they are reported or not. Default is \"false\".", in = ParameterIn.QUERY),
    })
    @GetMapping("/users/{userId}/comments/films/{filmId}")
    ResponseEntity<Map<String, Object>> getCommentByFilmIdAndUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId,
                                                                    @PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId,
                                                                    @RequestParam(defaultValue = "false") String reported) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.getCommentByFilmIdAndUserId(UUID.fromString(filmId), UUID.fromString(userId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Comments by Film ID",
            description = "This endpoint retrieves all comments associated with a specific film identified by its unique identifier. Users can filter comments based on reporting status, rating type (positive, neutral, negative, or all), and order the results by a specified field.",
            tags = { "Comment", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetCommentDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "ID of the film", in = ParameterIn.PATH),
            @Parameter(name = "reported", description = "Filter comments based on whether they are reported or not. Default is \"false\".", in = ParameterIn.QUERY),
            @Parameter(name = "userId", description = "Used to return true if a particular user has approved the comment by giving it a thumbs up.  Default is \"null\".", in = ParameterIn.QUERY),
            @Parameter(name = "rating", description = "Filter comments by rating type (positive, neutral, negative, or all). Default is \"all\".", in = ParameterIn.QUERY),
            @Parameter(name = "order", description = "Order comments by the specified field. Default is \"publicationDateTime\".",  example = "publicationDateTime",in = ParameterIn.QUERY),
            @Parameter(name = "page", description = "The number page of the request", in = ParameterIn.QUERY),
            @Parameter(name = "size", description = "The page size of each request", in = ParameterIn.QUERY),
    })
    @GetMapping("/films/{id}/comments")
    ResponseEntity<Map<String, Object>> getAllCommentByFilmIdAndRatingOrderByField(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                                                   @RequestParam(defaultValue = "false") Boolean reported,
                                                                                   @RequestParam(defaultValue = "all") String rating,
                                                                                   @RequestParam(defaultValue = "") String userId,
                                                                                   @RequestParam(defaultValue = "publicationDateTime") String order,
                                                                                   @RequestParam(defaultValue = "0") int page,
                                                                                   @RequestParam(defaultValue = "15") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, order));
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.getAllCommentByFilmIdAndRatingOrderByField(UUID.fromString(id), reported, rating, userId,pageable));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Total Ratings by Film ID",
            description = "This endpoint retrieves the sum of each rating type (positive, neutral, negative) for a specific film identified by its unique identifier. Users can filter ratings based on reporting status.",
            tags = { "Comment", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "ID ofthe film", in = ParameterIn.PATH),
            @Parameter(name = "reported", description = "Filter comments based on whether they are reported or not. Default is \"false\".", in = ParameterIn.QUERY),
    })
    @GetMapping("/films/{filmId}/comments/ratings")
    ResponseEntity<Map<String, Object>> getTotalRatingByFilmId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId,
                                                               @RequestParam(defaultValue = "false") Boolean reported) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.getTotalRatingByFilmId(UUID.fromString(filmId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Comment",
            description = "This endpoint allows users to update a specific comment identified by its unique identifier (ID). Users can modify the content or other properties of the comment using the provided update payload.",
            tags = { "Comment", "patch" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetCommentDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "commentId", description = "ID of the comment", required = true, in = ParameterIn.PATH),
            @Parameter(name = "updateCommentDto", description = "updateCommentDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UpdateCommentDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "USER")
    @PatchMapping("/comments/{commentId}")
    ResponseEntity<Map<String, Object>> updateComment(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String commentId,
                                                      @RequestBody @Valid UpdateCommentDto updateCommentDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", commentService.updateComment(UUID.fromString(commentId), updateCommentDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Comment",
            description = "This endpoint allows users to delete a specific comment identified by its unique identifier (ID). Deleting a comment is a permanent action and cannot be undone.",
            tags = { "Comment", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "commentId", description = "The ID of the Comment", required = true, in = ParameterIn.PATH),
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @DeleteMapping("/comments/{commentId}")
    ResponseEntity<String> deleteComment(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String commentId) {
        commentService.deleteComment(UUID.fromString(commentId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Comment: " + commentId + " deleted successfully");
    }
}