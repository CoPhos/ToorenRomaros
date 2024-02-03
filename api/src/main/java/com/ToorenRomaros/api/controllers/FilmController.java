package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.services.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.*;

@RestController
@RequestMapping("api/v1")
public class FilmController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final FilmService filmService;
    private static final Logger log = LoggerFactory.getLogger(FilmController.class);
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
        FilmDto film = filmService.getFilmById(UUID.fromString(id));
        Map<String, Object> response = new HashMap<>();
        response.put("response", film);
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
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "6") int size) throws Exception {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> films = filmService.getFilmByDynamicQuery(streamId, genres, suitableFor, filmType,
                atTheaters, atStreaming, commingSoonStreaming, commingSoonTheaters, orderBy, userRating, superRating, page, size);
        response.put("response", films.get("queryResult"));
        response.put("currentPage", films.get("pageNumber"));
        response.put("pageSize", films.get("pageSize"));
        response.put("maxResults", films.get("maxResults"));
        response.put("totalPages", films.get("totalPages"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("sagas/{id}/films")
    ResponseEntity<Map<String, Object>> getAllFilmBySagaId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", filmService.getAllFilmsBySagaId(UUID.fromString(id)));
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
