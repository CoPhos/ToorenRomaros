package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.SagaDto;
import com.ToorenRomaros.api.dto.genre.GenreFilmDto;
import com.ToorenRomaros.api.services.SagaService;
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
public class SagaController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";

    private final SagaService sagaService;

    public SagaController(SagaService sagaService) {
        this.sagaService = sagaService;
    }

    @PostMapping("/sagas")
    ResponseEntity<Map<String, Object>> createSaga(@RequestBody @Valid SagaDto sagaDto) throws Exception {
        SagaDto newSaga = sagaService.createSaga(sagaDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newSaga);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/sagas/{id}")
    ResponseEntity<Map<String, Object>> getSaga(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", sagaService.getSagaById(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/sagas/{id}")
    ResponseEntity<Map<String, Object>> updateSaga(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid SagaDto sagaDto) throws Exception {
        SagaDto updatedSaga = sagaService.updateSaga(UUID.fromString(id), sagaDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedSaga);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/sagas/{id}")
    ResponseEntity<String> deleteSaga(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        sagaService.deleteSaga(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Saga: " + id + " deleted successfully");
    }
}
