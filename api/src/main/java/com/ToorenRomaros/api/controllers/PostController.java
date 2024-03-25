package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.CreateFilmDto;
import com.ToorenRomaros.api.dto.film.GetFilmDto;
import com.ToorenRomaros.api.dto.film.UpdateFilmDto;
import com.ToorenRomaros.api.dto.publication.CreatePostDto;
import com.ToorenRomaros.api.dto.publication.GetPostDetailsDto;
import com.ToorenRomaros.api.dto.publication.GetPostDto;
import com.ToorenRomaros.api.dto.publication.UpdatePostDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.PostService;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@Tag(name = "Post", description = "Contains Post Entity Related Operations.")
public class PostController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(
            summary = "Create Post",
            description = "This endpoint allows users to create a new post by providing the necessary details using the provided payload.",
            tags = { "Post", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = GetPostDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "CreatePostDto", description = "CreatePostDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreatePostDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = {"ADMIN", "CRITIC"})
    @PostMapping("/posts")
    ResponseEntity<Map<String, Object>> createPost(@RequestBody @Valid CreatePostDto createPostDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", postService.createPost(createPostDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Post by ID",
            description = "This endpoint retrieves a specific post identified by its unique identifier (postId).",
            tags = { "Post", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetPostDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "postId", description = "ID of the Post", required = true, in = ParameterIn.PATH),
            @Parameter(name = "userId", description = "Used to return true if a particular user has approved the post by giving it a thumbs up.  Default is \"null\".", in = ParameterIn.QUERY),
    })
    @GetMapping("/posts/{postId}")
    ResponseEntity<Map<String, Object>> getPostById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String postId,
                                                    @RequestParam(defaultValue = "") String userId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", postService.getPostById(UUID.fromString(postId), userId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Operation(
            summary = "Get Posts by Custom Query",
            description = "This endpoint retrieves posts based on custom query parameters, allowing users to filter and sort posts based on specific criteria.",
            tags = { "Post", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetPostDetailsDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "tags", description = "List of tag IDs to filter posts by.", in = ParameterIn.QUERY),
            @Parameter(name = "isReview", description = "Filter posts that are reviews. Default is \"false\".", in = ParameterIn.QUERY),
            @Parameter(name = "latest", description = "Sort posts by the latest. Default is \"false\".", in = ParameterIn.QUERY),
            @Parameter(name = "popular", description = "Sort posts by popularity. Default is \"false\"", in = ParameterIn.QUERY),
            @Parameter(name = "search", description = "Perform a search query to filter posts by title.", in = ParameterIn.QUERY),
            @Parameter(name = "exclude", description = "ID of a post to ignore in the results.", in = ParameterIn.QUERY),
            @Parameter(name = "page", description = "The number page of the request.", in = ParameterIn.QUERY),
            @Parameter(name = "size", description = "The page size of each request. Default is \"6\"", in = ParameterIn.QUERY),
    })
    @GetMapping("/posts")
    ResponseEntity<Map<String, Object>> getPostByCustomQuery(@RequestParam(required = false) List<UUID> tags,
                                                             @RequestParam(required = false) boolean isReview,
                                                             @RequestParam(required = false) boolean latest,
                                                             @RequestParam(required = false) boolean popular,
                                                             @RequestParam(required = false) String search,
                                                             @RequestParam(required = false) UUID exclude,
                                                             @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "6") int size) throws Exception {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> posts = postService.getPostByCustomQuery(tags, isReview, latest, popular, search,exclude,page, size);
        response.put("response", posts.get("queryResult"));
        response.put("currentPage", posts.get("pageNumber"));
        response.put("pageSize", posts.get("pageSize"));
        response.put("maxResults", posts.get("maxResults"));
        response.put("totalPages", posts.get("totalPages"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Post",
            description = "This endpoint allows users to update a specific post identified by its unique identifier (id). Users can modify the properties of the post using the provided update payload.",
            tags = { "Post", "patch" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetPostDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "postId", description = "ID of the Post", required = true, in = ParameterIn.PATH),
            @Parameter(name = "UpdatePostDto", description = "UpdatePostDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UpdatePostDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = {"ADMIN", "CRITIC"})
    @PatchMapping("/posts/{postId}")
    ResponseEntity<Map<String, Object>> updatePost(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String postId,
                                                      @RequestBody @Valid UpdatePostDto postDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", postService.updatePostById(UUID.fromString(postId), postDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Total Critic Rating by Film ID",
            description = "This endpoint retrieves the total critic rating for a specific film identified by its unique identifier (filmId).",
            tags = { "Post", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "ID of the Film", required = true, in = ParameterIn.PATH),
            @Parameter(name = "reported", description = "Filter comments based on whether they are reported or not. Default is \"false\".", in = ParameterIn.QUERY),
    })
    @GetMapping("/films/{filmId}/posts/ratings")
    ResponseEntity<Map<String, Object>> getTotalCriticRatingByFilmId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId,
                                                               @RequestParam(defaultValue = "false") Boolean reported) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", postService.getTotalRatingByFilmId(UUID.fromString(filmId)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Latest Review Post by Film ID and User ID",
            description = "This endpoint retrieves the latest review post from a specific user (identified by userId) for a specific film (identified by filmId).",
            tags = { "Post", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetPostDetailsDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "userId", description = "ID of the User", required = true, in = ParameterIn.PATH),
            @Parameter(name = "filmId", description = "ID of the Film", required = true, in = ParameterIn.PATH),
            @Parameter(name = "reported", description = "Filter comments based on whether they are reported or not. Default is \"false\".", in = ParameterIn.QUERY),
    })
    @GetMapping("/users/{userId}/films/{filmId}/posts/reviews")
    ResponseEntity<Map<String, Object>> getLatestReviewPostByFilmIdAndUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId,
                                                                             @PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", postService.getLatestReviewPostByFilmIdAndUserIdAndRatingNotNull(UUID.fromString(userId), UUID.fromString(filmId) ));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Review Post by User ID. Latest post first.",
            description = "This endpoint retrieves the all reviews post from a specific user (identified by userId).",
            tags = { "Post", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetPostDetailsDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "userId", description = "ID of the User", required = true, in = ParameterIn.PATH),
            @Parameter(name = "filmType", description = "Filter films by type (e.g., \"all\", \"1\", \"2\"). Default is \"all\". (1 is for movies, 2 is for series).", in = ParameterIn.QUERY),
            @Parameter(name = "page", description = "The number page of the request.", in = ParameterIn.QUERY),
            @Parameter(name = "size", description = "The page size of each request. Default is \"15\"", in = ParameterIn.QUERY),
    })
    @GetMapping("/users/{userId}/posts")
    ResponseEntity<Map<String, Object>> getLatestReviewsByUserIdAndFilmType(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId,
                                                                            @RequestParam (defaultValue = "1") int filmType,
                                                                            @RequestParam(defaultValue = "0") int page,
                                                                            @RequestParam(defaultValue = "15") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "publicationDateTime"));
        Map<String, Object> response = new HashMap<>();
        response.put("response", postService.getLatestReviewsByUserIdAndFilmType(UUID.fromString(userId), filmType, pageable));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Not Finished Post (Drafts) by User ID. Latest post first.",
            description = "This endpoint retrieves the all drafts from a specific user (identified by userId).",
            tags = { "Post", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetPostDetailsDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "userId", description = "ID of the User", required = true, in = ParameterIn.PATH),
            @Parameter(name = "page", description = "The number page of the request.", in = ParameterIn.QUERY),
            @Parameter(name = "size", description = "The page size of each request. Default is \"15\"", in = ParameterIn.QUERY),
    })
    @GetMapping("/users/{userId}/posts/drafts")
    ResponseEntity<Map<String, Object>> getLatestDraftsByUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId,
                                                                            @RequestParam(defaultValue = "0") int page,
                                                                            @RequestParam(defaultValue = "15") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "publicationDateTime"));
        Map<String, Object> response = new HashMap<>();
        response.put("response", postService.getLatestDraftsByUserId(UUID.fromString(userId), pageable));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Posts From a Specifi Film by Custom Query",
            description = "This endpoint retrieves posts from a specific film based on custom query parameters, allowing users to filter and sort posts based on specific criteria.",
            tags = { "Post", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetPostDetailsDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "filmId", description = "ID of the Film", required = true, in = ParameterIn.PATH),
            @Parameter(name = "reported", description = "Filter posts based on whether they are reported or not. Default is \"false\".", in = ParameterIn.QUERY),
            @Parameter(name = "rating", description = "Filter posts by rating type (positive, neutral, negative, or all). Default is \"all\".", in = ParameterIn.QUERY),
            @Parameter(name = "order", description = "Filter posts by field name. Default is \"publicationDateTime\".", in = ParameterIn.QUERY),
            @Parameter(name = "page", description = "The number page of the request.", in = ParameterIn.QUERY),
            @Parameter(name = "size", description = "The page size of each request. Default is \"15\"", in = ParameterIn.QUERY),
    })
    @GetMapping("/films/{filmId}/posts/reviews")
    ResponseEntity<Map<String, Object>> getReviewPostsByFilmIdAndRatingOrderByField(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String filmId,
                                                               @RequestParam(defaultValue = "false") Boolean reported,
                                                               @RequestParam(defaultValue = "all") String rating,
                                                               @RequestParam(defaultValue = "publicationDateTime") String order,
                                                               @RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "15") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, order));
        Map<String, Object> response = new HashMap<>();
        response.put("response", postService.getReviewPostsByFilmIdAndRatingOrderByField(UUID.fromString(filmId),rating, pageable));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Post",
            description = "This endpoint allows users to delete a specific post identified by its unique identifier (id). Deleting a post is a permanent action and cannot be undone.",
            tags = { "Post", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "postId", description = "The ID of the Post", required = true, in = ParameterIn.PATH),
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = {"ADMIN", "CRITIC"})
    @DeleteMapping("/posts/{postId}")
    ResponseEntity<String> deletePost(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String postId) {
        postService.deletePostById(UUID.fromString(postId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Post: " + postId + " deleted successfully");
    }
}
