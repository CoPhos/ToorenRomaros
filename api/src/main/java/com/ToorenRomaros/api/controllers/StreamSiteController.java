package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.streamSite.StreamSiteDto;
import com.ToorenRomaros.api.services.StreamSiteService;
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
public class StreamSiteController {
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final StreamSiteService streamSiteService;

    public StreamSiteController(StreamSiteService streamSiteService) {
        this.streamSiteService = streamSiteService;
    }

    @PostMapping("/streaming")
    ResponseEntity<Map<String, Object>> createStreamSite(@RequestBody @Valid StreamSiteDto streamSiteDto) throws Exception {
        StreamSiteDto newStreamSite = streamSiteService.createStreamSite(streamSiteDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newStreamSite);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/streaming/{id}")
    ResponseEntity<Map<String, Object>> getStreamSite(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        StreamSiteDto streamSite = streamSiteService.getStreamSite(UUID.fromString(id));
        Map<String, Object> response = new HashMap<>();
        response.put("response", streamSite);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/streaming/{id}")
    ResponseEntity<Map<String, Object>> updateStreamSite(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid StreamSiteDto streamSiteDto) throws Exception {
        StreamSiteDto updatedStreamSite = streamSiteService.updateStreamSite(UUID.fromString(id), streamSiteDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updatedStreamSite);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/streaming/{id}")
    ResponseEntity<String> deleteStreamSite(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        streamSiteService.deleteStreamSite(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Stream site: " + id + " deleted successfully");
    }
}
