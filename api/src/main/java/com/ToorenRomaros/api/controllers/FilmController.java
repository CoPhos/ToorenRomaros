package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.CreateFilmDto;
import com.ToorenRomaros.api.dto.film.UpdateFilmDto;
import com.ToorenRomaros.api.services.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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
    ResponseEntity<Map<String, Object>> createFilm(@RequestBody @Valid CreateFilmDto createFilmDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", filmService.createFilm(createFilmDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/films/{id}")
    ResponseEntity<Map<String, Object>> getFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", filmService.getFilmById(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/films")
    ResponseEntity<Map<String, Object>> getFilmByDynamicQuery(@RequestParam(required = false) List<String> streamId,
                                                              @RequestParam(required = false) List<String> genres,
                                                              @RequestParam(required = false) List<String> suitableFor,
                                                              @RequestParam(defaultValue = "all") String filmType,
                                                              @RequestParam(required = false) String atTheaters,
                                                              @RequestParam(required = false) String commingSoonStreaming,
                                                              @RequestParam(required = false) String commingSoonTheaters,
                                                              @RequestParam(required = false) String atStreaming,
                                                              @RequestParam(defaultValue = "tittle-asc") String[] orderBy,
                                                              @RequestParam(required = false) String userRating,
                                                              @RequestParam(required = false) String superRating,
                                                              @RequestParam(required = false) String search,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "6") int size) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> films = filmService.getFilmByDynamicQuery(streamId, genres, suitableFor, filmType,
                atTheaters, atStreaming, commingSoonStreaming, commingSoonTheaters, orderBy, userRating, superRating, search, page, size);
        response.put("response", films.get("queryResult"));
        response.put("currentPage", films.get("pageNumber"));
        response.put("pageSize", films.get("pageSize"));
        response.put("maxResults", films.get("maxResults"));
        response.put("totalPages", films.get("totalPages"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("sagas/{id}/films")
    ResponseEntity<Map<String, Object>> getAllFilmBySagaId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", filmService.getAllFilmsBySagaId(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PatchMapping("/films/{id}")
    ResponseEntity<Map<String, Object>> updateFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid UpdateFilmDto updateFilmDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("updated", filmService.updateFilm(UUID.fromString(id), updateFilmDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/films/{id}")
    ResponseEntity<String> deleteFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) {
        filmService.deleteFilm(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Film: " + id + " deleted successfully");
    }
}
