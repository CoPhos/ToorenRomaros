package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.staff.StaffDto;
import com.ToorenRomaros.api.dto.staff.StaffFilmDto;
import com.ToorenRomaros.api.services.StaffFilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class StaffFilmController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final StaffFilmService staffFilmService;

    public StaffFilmController(StaffFilmService staffFilmService) {
        this.staffFilmService = staffFilmService;
    }

    @PostMapping("/films/staffs")
    ResponseEntity<Map<String, Object>> createStaffFilm(@RequestBody @Valid StaffFilmDto staffFilmDto) throws Exception {
        StaffFilmDto newStaffFilm = staffFilmService.addStaffFilm(staffFilmDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newStaffFilm);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
