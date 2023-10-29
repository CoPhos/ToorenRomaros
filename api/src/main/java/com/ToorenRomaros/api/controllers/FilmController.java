package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dao.FilmRepositoryCustomImpl;
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
    @GetMapping("/films/test")
    ResponseEntity<Map<String, Object>> getFilmTest(@RequestParam(required = false) String streamId,
                                                    @RequestParam(required = false) List<UUID> genres,
                                                    @RequestParam(required = false) String suitableFor,
                                                    @RequestParam(required = false) String filmType,
                                                    @RequestParam(required = false) boolean atTheaters,
                                                    @RequestParam(required = false) boolean coomingSoon,
                                                    @RequestParam(required = false) boolean atStreaming) throws Exception {
        try {
            Map<String, Object> response = new HashMap<>();
            log.info(streamId);
            response.put("response", filmService.testRepositoryCustom(streamId, genres, suitableFor,filmType,atTheaters,coomingSoon,atStreaming));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            log.info(e.getMessage());
            log.info(e.getCause().toString());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

//        http://localhost:9090/api/v1/films/test?streamId=7b0c02cc-efaa-4d9b-8619-8babb56e7b40&genres=4ba05e0c-43d7-45b1-943f-d3a8b863dec1,dbe4b00f-7817-44aa-9942-bf05da8fb84f&suitableFor=PG-13&filmType=1&atTheaters=TRUE&coomingSoon=TRUE&atStreaming=TRUE
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
