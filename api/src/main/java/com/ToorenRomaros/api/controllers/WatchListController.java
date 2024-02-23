package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.watchList.CreateWatchListDto;
import com.ToorenRomaros.api.services.WatchListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public class WatchListController {
    private static final Logger log = LoggerFactory.getLogger(WatchListController.class);
    private static final String uuidRegExp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final WatchListService watchListService;

    public WatchListController(WatchListService watchListService) {
        this.watchListService = watchListService;
    }
    @GetMapping("users/{id}/watchLists")
    ResponseEntity<Map<String, Object>> getWatchListFromUser(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String id,
                                                             @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size)
                                                             throws Exception {

            Pageable pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "addedDate"));
            Map<String, Object> response = new HashMap<>();
            response.put("response", watchListService.getWatchListFromUserByFilmType(UUID.fromString(id), "1", pageRequest));
            return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @PostMapping("/watchLists")
    ResponseEntity<Map<String, Object>> createWatchList(@RequestBody @Valid CreateWatchListDto createWatchListDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", watchListService.createWatchList(createWatchListDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/watchLists/users/{userId}")
    ResponseEntity<String>  deleteFilmFromWatchList(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId,
                                                    @RequestParam @NotNull @Pattern(regexp = uuidRegExp) String filmId) throws Exception {
        watchListService.deleteFromWatchListByUserIdAndFilmId(UUID.fromString(userId), UUID.fromString(filmId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(filmId);
    }
}
