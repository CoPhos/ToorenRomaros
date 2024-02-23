package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.genre.GenreDto;
import com.ToorenRomaros.api.services.GenreService;
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
public class GenreController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/genre")
    ResponseEntity<Map<String, Object>> createGenre(@RequestBody @Valid GenreDto genreDto) throws Exception {
        GenreDto newGenre = genreService.createGenre(genreDto);
        Map<String, Object> response = new HashMap<>();
        response.put("response", newGenre);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/genre/{id}")
    ResponseEntity<Map<String, Object>> getGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        GenreDto genre = genreService.getGenre(UUID.fromString(id));
        Map<String, Object> response = new HashMap<>();
        response.put("response", genre);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PatchMapping("/genre/{id}")
    ResponseEntity<Map<String, Object>> updateGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody GenreDto genreDto) throws Exception {
        GenreDto updatedGenre = genreService.updateGenre(UUID.fromString(id), genreDto);
        Map<String, Object> response = new HashMap<>();
        response.put("response", updatedGenre);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/genre/{id}")
    ResponseEntity<String> deleteGenre(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        genreService.deleteGenre(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Genre: " + id + " deleted successfully");
    }
}
