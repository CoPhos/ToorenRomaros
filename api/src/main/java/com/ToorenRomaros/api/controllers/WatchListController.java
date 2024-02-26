package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.staff.GetStaffDto;
import com.ToorenRomaros.api.dto.tag.CreateTagDto;
import com.ToorenRomaros.api.dto.tag.GetTagDto;
import com.ToorenRomaros.api.dto.watchList.CreateWatchListDto;
import com.ToorenRomaros.api.dto.watchList.GetWatchListDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.WatchListService;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@Tag(name = "Watch List", description = "Contains Watch List Entity Related Operations.")
public class WatchListController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final WatchListService watchListService;

    public WatchListController(WatchListService watchListService) {
        this.watchListService = watchListService;
    }

    @Operation(
            summary = "Get Watchlist from User",
            description = "This endpoint retrieves all items from a user's watchlist identified by the user's unique identifier (id).",
            tags = { "Watchlist", "User", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetWatchListDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "userId", description = "ID of the User", required = true, in = ParameterIn.PATH),
            @Parameter(name = "page", description = "The number page of the request.", in = ParameterIn.QUERY),
            @Parameter(name = "size", description = "The page size of each request. Default is \"15\"", in = ParameterIn.QUERY),
    })
    @GetMapping("users/{userId}/watchLists")
    ResponseEntity<Map<String, Object>> getWatchListFromUser(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId,
                                                             @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size) {

            Pageable pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "addedDate"));
            Map<String, Object> response = new HashMap<>();
            response.put("response", watchListService.getWatchListFromUserByFilmType(UUID.fromString(userId), "1", pageRequest));
            return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @Operation(
            summary = "Create Watch List",
            description = "This endpoint allows users to add a new Watch List item by providing the necessary details using the provided payload.",
            tags = { "Watch List", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = CreateWatchListDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "GetWatchListDto", description = "GetWatchListDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetWatchListDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/watchLists")
    ResponseEntity<Map<String, Object>> createWatchList(@RequestBody @Valid CreateWatchListDto createWatchListDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", watchListService.createWatchList(createWatchListDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Delete Watch List",
            description = "This endpoint allows users to delete a specific Watch List identified by its unique identifier (id). Deleting a Watch List is a permanent action and cannot be undone.",
            tags = { "Watch List", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "userId", description = "The ID of the User", required = true, in = ParameterIn.PATH),
            @Parameter(name = "filmId", description = "The ID of the Film", required = true, in = ParameterIn.QUERY),
    })
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/watchLists/users/{userId}")
    ResponseEntity<String>  deleteFilmFromWatchList(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId,
                                                    @RequestParam @NotNull @Pattern(regexp = uuidRegExp) String filmId) throws Exception {
        watchListService.deleteFromWatchListByUserIdAndFilmId(UUID.fromString(userId), UUID.fromString(filmId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(filmId);
    }
}
