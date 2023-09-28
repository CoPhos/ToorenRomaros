package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.MovieDto;
import com.ToorenRomaros.api.dto.film.MovieRequestDto;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.services.FilmService;
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
@RequestMapping("/api/v1")
public class FilmController {

    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping("/films")
    ResponseEntity<Map<String, Object>> createFilm(@RequestBody @Valid MovieRequestDto movieRequestDto) throws Exception {
        MovieDto newFilm = filmService.createFilm(movieRequestDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newFilm);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
