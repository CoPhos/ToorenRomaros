package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.staff.CreateStaffFilmDto;
import com.ToorenRomaros.api.services.StaffFilmService;
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
public class StaffFilmController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final StaffFilmService staffFilmService;

    public StaffFilmController(StaffFilmService staffFilmService) {
        this.staffFilmService = staffFilmService;
    }

    @PostMapping("/films/staffs")
    ResponseEntity<Map<String, Object>> createStaffFilm(@RequestBody @Valid CreateStaffFilmDto createStaffFilmDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", staffFilmService.addStaffFilm(createStaffFilmDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/films/{id}/staffs")
    ResponseEntity<Map<String, Object>> getStaffFilmByFilmId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", staffFilmService.getAllStaffFromFilm(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @DeleteMapping("/films/staffs/{id}")
    ResponseEntity<String> deleteStaffFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        staffFilmService.deleteStaffFilm(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Staff from film: " + id + " deleted successfully");
    }
}
