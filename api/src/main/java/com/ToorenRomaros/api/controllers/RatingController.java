package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.SagaDto;
import com.ToorenRomaros.api.dto.publication.RatingDto;
import com.ToorenRomaros.api.services.RatingService;
import com.ToorenRomaros.api.services.SocialGenericUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class RatingController {
    private final RatingService ratingService;
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    private static final Logger log = LoggerFactory.getLogger(RatingController.class);

    @PostMapping("/ratings")
    ResponseEntity<Map<String, Object>> createRating(@RequestBody @Valid RatingDto ratingDto) throws Exception {
        RatingDto newRating = ratingService.createRating(ratingDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", newRating);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/ratings/{id}")
    ResponseEntity<Map<String, Object>> getRatingById(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", ratingService.getRating(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/films/{id}/ratings")
    ResponseEntity<Map<String, Object>> getAllRatingsByFilmId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestParam Boolean superRating) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", ratingService.getAllRatingByFilmIdAndRatingType(UUID.fromString(id), superRating));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/users/{id}/ratings")
    ResponseEntity<Map<String, Object>> getAllRatingsByUserId(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", ratingService.getAllRatingByUserId(UUID.fromString(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/ratings/{id}")
    ResponseEntity<Map<String, Object>> updateRating(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id, @RequestBody @Valid RatingDto ratingDto) throws Exception {
        RatingDto updateRating = ratingService.updateRating(UUID.fromString(id), ratingDto);
        Map<String, Object> response = new HashMap<>();
        response.put("updated", updateRating);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/ratings/{id}")
    ResponseEntity<String> deleteRating(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id) throws Exception {
        ratingService.deleteRating(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Saga: " + id + " deleted successfully");
    }
}
