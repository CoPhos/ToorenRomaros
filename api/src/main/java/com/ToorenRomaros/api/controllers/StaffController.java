package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.staff.StaffDto;
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
    ResponseEntity<Map<String, Object>> createStaff(@RequestBody @Valid StaffDto staffDto) throws Exception {
        StaffDto newStaff = staffService.createStaff(staffDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newStaff);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/staffs/{id}")
    ResponseEntity<Map<String, Object>> getStaff(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        StaffDto staff = staffService.getStaffById(UUID.fromString(id));
        Map<String, Object> response = new HashMap<>();
        response.put("response", staff);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/staffs/{id}")
    ResponseEntity<Map<String, Object>> updateStaff(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody StaffDto staffDto) throws Exception {
        StaffDto updatedStaff = staffService.updateStaff(UUID.fromString(id), staffDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedStaff);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/staffs/{id}")
    ResponseEntity<String> deleteStaff(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        staffService.deleteStaffByid(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Staff: " + id + " deleted successfully");
    }
}
