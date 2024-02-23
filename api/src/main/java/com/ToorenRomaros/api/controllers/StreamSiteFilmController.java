package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.streamSite.CreateStreamSiteFilmDto;
import com.ToorenRomaros.api.services.StreamSiteFilmService;
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
public class StreamSiteFilmController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final StreamSiteFilmService streamSiteFilmService;
    public StreamSiteFilmController(StreamSiteFilmService streamSiteFilmService) {
        this.streamSiteFilmService = streamSiteFilmService;
    }

    @PostMapping("/streaming/film")
    ResponseEntity<Map<String, Object>> createStreamSiteFilm(@RequestBody @Valid CreateStreamSiteFilmDto createStreamSiteFilmDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", streamSiteFilmService.createStreamSiteFilm(createStreamSiteFilmDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/films/{id}/streamingsites")
    ResponseEntity<Map<String, Object>> getStreamSiteFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", streamSiteFilmService.getStreamSitesByFilmId(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/streaming/film/{id}")
    ResponseEntity<String> deleteStreamSiteFilm(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        streamSiteFilmService.deleteStreamSiteFilm(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Stream site from Film: " + id + " deleted successfully");
    }
}
