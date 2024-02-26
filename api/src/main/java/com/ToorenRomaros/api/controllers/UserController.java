package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.staff.GetStaffDto;
import com.ToorenRomaros.api.dto.staff.UpdateStaffDto;
import com.ToorenRomaros.api.dto.user.*;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.UserService;
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
@Tag(name = "User", description = "Contains User Entity Related Operations.")
public class UserController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Operation(
            summary = "Get User by ID",
            description = "This endpoint retrieves a specific User identified by its unique identifier (id).",
            tags = { "User", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetStaffDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "userId", description = "ID of the User", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/users/{userId}")
    ResponseEntity<Map<String, Object>> getUserById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", userService.getUserById(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @Operation(
            summary = "Update User",
            description = "This endpoint allows users to update his own User entity identified by its unique identifier (userId). Users can modify the properties of the user using the provided update payload.",
            tags = { "Staff", "patch" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = UserDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "username", description = "Current username", required = true, in = ParameterIn.PATH),
            @Parameter(name = "userId", description = "ID of the User", required = true, in = ParameterIn.PATH),
            @Parameter(name = "UpdateUserDto", description = "UpdateUserDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UpdateUserDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = {"ADMIN", "USER"})
    @PatchMapping("/users/{username}/{userId}")
    ResponseEntity<Map<String, Object>> updateUser(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,@PathVariable String username, @RequestBody @Valid UpdateUserDto updateUserDto) {
        UserDto updatedUser = userService.updateUser(UUID.fromString(id), updateUserDto, username);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User",
            description = "This endpoint allows users to delete a specific User identified by its unique identifier (id). Deleting a User is a permanent action and cannot be undone.",
            tags = { "User", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "userId", description = "The ID of the User", required = true, in = ParameterIn.PATH),
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = {"ADMIN"})
    @DeleteMapping("/users/{userId}")
    ResponseEntity<String> deleteUserById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId) {
        userService.deleteUserById(UUID.fromString(userId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("User: " + userId + " deleted successfully");
    }
}