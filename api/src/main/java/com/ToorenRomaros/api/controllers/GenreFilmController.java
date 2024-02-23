package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.genre.CreateGenreFilmDto;
import com.ToorenRomaros.api.services.GenreFilmService;
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
public class GenreFilmController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final GenreFilmService genreFilmService;

    public GenreFilmController(GenreFilmService genreFilmService) {
        this.genreFilmService = genreFilmService;
    }

    @PostMapping("/films/genres")
    ResponseEntity<Map<String, Object>> createFilmGenre(@RequestBody @Valid CreateGenreFilmDto createGenreFilmDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("created",  genreFilmService.createGenreFilm(createGenreFilmDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/films/{id}/genres")
    ResponseEntity<Map<String, Object>> getFilmGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", genreFilmService.getGenreFilm(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/films/{id}/genres")
    ResponseEntity<Map<String, Object>> updateFilmGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid CreateGenreFilmDto createGenreFilmDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("updated", genreFilmService.updateGenreFilm(UUID.fromString(id), createGenreFilmDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/films/genres/{id}")
    ResponseEntity<String> deleteFilmGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        genreFilmService.deleteGenreFilm(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Film genre: " + id + " deleted successfully");
    }
}
