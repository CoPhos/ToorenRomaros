package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.staff.CreateStaffDto;
import com.ToorenRomaros.api.dto.staff.UpdateStaffDto;
import com.ToorenRomaros.api.services.StaffService;
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
public class StaffController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/staffs")
    ResponseEntity<Map<String, Object>> createStaff(@RequestBody @Valid CreateStaffDto createStaffDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", staffService.createStaff(createStaffDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/staffs/{id}")
    ResponseEntity<Map<String, Object>> getStaff(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", staffService.getStaffById(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PatchMapping("/staffs/{id}")
    ResponseEntity<Map<String, Object>> updateStaff(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid UpdateStaffDto createStaffDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", staffService.updateStaff(UUID.fromString(id), createStaffDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/staffs/{id}")
    ResponseEntity<String> deleteStaff(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        staffService.deleteStaffByid(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Staff: " + id + " deleted successfully");
    }
}
