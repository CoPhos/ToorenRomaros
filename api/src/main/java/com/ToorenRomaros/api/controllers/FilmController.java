package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.services.FilmService;
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
public class FilmController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping("/films")
    ResponseEntity<Map<String, Object>> createFilm(@RequestBody @Valid FilmDto filmDto) throws Exception {
        FilmDto newFilm = filmService.createFilm(filmDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newFilm);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/films/{id}")
    ResponseEntity<Map<String, Object>> getFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        FilmDto film = filmService.findFilmById(UUID.fromString(id));
        Map<String, Object> response = new HashMap<>();
        response.put("response", film);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/films/{id}")
    ResponseEntity<Map<String, Object>> updateSerie(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid FilmDto filmDto) throws Exception {
        FilmDto updatedFilm = filmService.updateFilm(UUID.fromString(id), filmDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedFilm);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/films/{id}")
    ResponseEntity<String> deleteFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        filmService.deleteFilm(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Film: " + id + " deleted successfully");
    }

}
