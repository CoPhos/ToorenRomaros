package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.dto.watchList.WatchListDto;
import com.ToorenRomaros.api.services.WatchListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

            Pageable pageRequest = PageRequest.of(page, size);
            Page<WatchListDto> pageWatchList = watchListService.getWatchListFromUserByFilmType(UUID.fromString(id), "1", pageRequest);
            Map<String, Object> response = new HashMap<>();
            response.put("content", pageWatchList.getContent());
            response.put("currentPage", pageWatchList.getNumber());
            response.put("totalItems", pageWatchList.getNumberOfElements());
            response.put("totalPages", pageWatchList.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @PostMapping("/watchLists")
    ResponseEntity<Map<String, Object>> createWatchList(@RequestBody @Valid WatchListDto watchListDto) throws Exception {
        try{
        WatchListDto CretedWatchListDto = watchListService.createWatchList(watchListDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", CretedWatchListDto);
        return new ResponseEntity<>(response, HttpStatus.OK); }catch (Exception e){
            log.info(e.getMessage());
        }
        return null;
    }
    @DeleteMapping("/watchLists/users/{userId}")
    ResponseEntity<String>  deleteFilmFromWatchList(@PathVariable @NotNull @Pattern(regexp = uuidRegExp) String userId,
                                                    @RequestParam @NotNull @Pattern(regexp = uuidRegExp) String filmId) throws Exception {
        watchListService.deleteFromWatchListByUserIdAndFilmId(UUID.fromString(userId), UUID.fromString(filmId));
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(filmId);
    }
}
