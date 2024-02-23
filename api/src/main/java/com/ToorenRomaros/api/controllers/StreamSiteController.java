package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.streamSite.CreateStreamSiteDto;
import com.ToorenRomaros.api.dto.streamSite.UpdateStreamSiteDto;
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
    ResponseEntity<Map<String, Object>> createStreamSite(@RequestBody @Valid CreateStreamSiteDto createStreamSiteDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", streamSiteService.createStreamSite(createStreamSiteDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/streaming/{id}")
    ResponseEntity<Map<String, Object>> getStreamSite(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", streamSiteService.getStreamSite(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PatchMapping("/streaming/{id}")
    ResponseEntity<Map<String, Object>> updateStreamSite(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid UpdateStreamSiteDto createStreamSiteDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", streamSiteService.updateStreamSite(UUID.fromString(id), createStreamSiteDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/streaming/{id}")
    ResponseEntity<String> deleteStreamSite(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        streamSiteService.deleteStreamSite(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Stream site: " + id + " deleted successfully");
    }
}
