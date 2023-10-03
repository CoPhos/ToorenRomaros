package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.SerieDto;
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
@RequestMapping("/api/v1")
public class FilmController {

    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping("/movies")
    ResponseEntity<Map<String, Object>> createMovie(@RequestBody @Valid MovieDto movieDto) throws Exception {
        MovieDto newFilm = filmService.createMovie(movieDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newFilm);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/series")
    ResponseEntity<Map<String, Object>> createSerie(@RequestBody @Valid SerieDto serieDto) throws Exception {
        SerieDto newSerie = filmService.createSerie(serieDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newSerie);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/movies/{id}")
    ResponseEntity<Map<String, Object>> getMovie(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        MovieDto movie = filmService.findMovieById(UUID.fromString(id));
        Map<String, Object> response = new HashMap<>();
        response.put("response", movie);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/series/{id}")
    ResponseEntity<Map<String, Object>> getSerie(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        SerieDto serie = filmService.findSerieById(UUID.fromString(id));
        Map<String, Object> response = new HashMap<>();
        response.put("response", serie);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/movies/{id}")
    ResponseEntity<Map<String, Object>> updateMovie(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid MovieDto movieDto) throws Exception {
        MovieDto updataedMovie = filmService.updateMovie(UUID.fromString(id), movieDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updataedMovie);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/series/{id}")
    ResponseEntity<Map<String, Object>> updateSerie(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid SerieDto serieDto) throws Exception {
        SerieDto updatedSerie = filmService.updateSerie(UUID.fromString(id), serieDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedSerie);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
