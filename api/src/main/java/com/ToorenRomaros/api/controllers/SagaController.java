package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.SagaDto;
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
    ResponseEntity<Map<String, Object>> createSaga(@RequestBody @Valid SagaDto sagaDto){
        Map<String, Object> response = new HashMap<>();
        response.put("response", sagaService.createSaga(sagaDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/sagas/{id}")
    ResponseEntity<Map<String, Object>> getSaga(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id){
        Map<String, Object> response = new HashMap<>();
        response.put("response", sagaService.getSagaById(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PatchMapping("/sagas/{id}")
    ResponseEntity<Map<String, Object>> updateSaga(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid SagaDto sagaDto){
        Map<String, Object> response = new HashMap<>();
        response.put("response", sagaService.updateSaga(UUID.fromString(id), sagaDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/sagas/{id}")
    ResponseEntity<String> deleteSaga(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id){
        sagaService.deleteSaga(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Saga: " + id + " deleted successfully");
    }
}