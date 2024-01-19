package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.RatingDto;
import com.ToorenRomaros.api.dto.staff.StaffFilmDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface RatingService {
    RatingDto createRating(RatingDto ratingDto);
    RatingDto getRating(UUID id);
    List<RatingDto> getAllRatingByUserId(UUID id);
    RatingDto updateRating(UUID id, RatingDto ratingDto);
    Map<String, Map<String, Object> > getTotalRatingByFilmIdAndRatingType(UUID id);
    void deleteRating (UUID id);
}
