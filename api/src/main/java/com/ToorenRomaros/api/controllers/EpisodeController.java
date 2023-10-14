package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.EpisodeDto;
import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.services.EpisodeService;
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
public class EpisodeController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @PostMapping("/episodes")
    ResponseEntity<Map<String, Object>> createEpisode(@RequestBody @Valid EpisodeDto episodeDto) throws Exception {
        EpisodeDto newEpisode = episodeService.createEpisode(episodeDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newEpisode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/episodes/{id}")
    ResponseEntity<Map<String, Object>> getEpisode(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        EpisodeDto episode = episodeService.getEpisodeById(UUID.fromString(id));
        Map<String, Object> response = new HashMap<>();
        response.put("response", episode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/series/{id}/episodes/")
    ResponseEntity<Map<String, Object>> getAllEpisodeBySerieId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", episodeService.getAllEpisodesBySerieId(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/episodes/{id}")
    ResponseEntity<Map<String, Object>> updateEpisode(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid EpisodeDto episodeDto) throws Exception {
        EpisodeDto updateEpisode = episodeService.updateEpisode(UUID.fromString(id), episodeDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updateEpisode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/episodes/{id}")
    ResponseEntity<String> deleteEpisode(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        episodeService.deleteEpisode(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Episode: " + id + " deleted successfully");
    }
}
