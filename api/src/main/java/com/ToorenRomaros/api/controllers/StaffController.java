package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.GetFilmDto;
import com.ToorenRomaros.api.dto.film.SagaDto;
import com.ToorenRomaros.api.dto.staff.CreateStaffDto;
import com.ToorenRomaros.api.dto.staff.GetStaffDto;
import com.ToorenRomaros.api.dto.staff.UpdateStaffDto;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.services.StaffService;
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
public class StaffController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @Operation(
            summary = "Create Stafff",
            description = "This endpoint allows users to create a new staff by providing the necessary details using the provided payload.",
            tags = { "Saga", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = CreateStaffDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "GetStaffDto", description = "GetStaffDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetStaffDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PostMapping("/staffs")
    ResponseEntity<Map<String, Object>> createStaff(@RequestBody @Valid CreateStaffDto createStaffDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", staffService.createStaff(createStaffDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Staff by ID",
            description = "This endpoint retrieves a specific staff identified by its unique identifier (id).",
            tags = { "Staff", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetStaffDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "staffId", description = "ID of the Staff", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/staffs/{staffId}")
    ResponseEntity<Map<String, Object>> getStaff(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", staffService.getStaffById(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Staff",
            description = "This endpoint allows users to update a specific Staff entity identified by its unique identifier (staffId). Users can modify the properties of the staff using the provided update payload.",
            tags = { "Staff", "patch" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GetStaffDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "staffId", description = "ID of the Staff", required = true, in = ParameterIn.PATH),
            @Parameter(name = "UpdateStaffDto", description = "UpdateStaffDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UpdateStaffDto.class)))
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = "ADMIN")
    @PatchMapping("/staffs/{staffId}")
    ResponseEntity<Map<String, Object>> updateStaff(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid UpdateStaffDto createStaffDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", staffService.updateStaff(UUID.fromString(id), createStaffDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Staff",
            description = "This endpoint allows users to delete a specific staff identified by its unique identifier (id). Deleting a staff is a permanent action and cannot be undone.",
            tags = { "Staff", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "staffId", description = "The ID of the Staff", required = true, in = ParameterIn.PATH),
    })
    @SecurityRequirement(name = "Bearer Authentication", scopes = {"ADMIN"})
    @DeleteMapping("/staffs/{staffId}")
    ResponseEntity<String> deleteStaff(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String staffId) {
        staffService.deleteStaffByid(UUID.fromString(staffId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Staff: " + staffId + " deleted successfully");
    }
}
