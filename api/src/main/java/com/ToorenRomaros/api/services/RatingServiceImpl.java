package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.publication.RatingDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.publication.RatingEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.publication.RatingRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final FilmRepository filmRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private static final Logger log = LoggerFactory.getLogger(RatingServiceImpl.class);

    public RatingServiceImpl(RatingRepository ratingRepository, FilmRepository filmRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.ratingRepository = ratingRepository;
        this.filmRepository = filmRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RatingDto createRating(RatingDto ratingDto) {
        RatingEntity ratingEntity = modelMapper.map(ratingDto, RatingEntity.class);

        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(ratingDto.getFilmId())).orElseThrow(() -> new ResourceNotFoundException("'" + ratingDto.getFilmId() + "'"));
        UserEntity userEntity = userRepository.findById(UUID.fromString(ratingDto.getUserId())).orElseThrow(() -> new ResourceNotFoundException("'" + ratingDto.getUserId() + "'"));

        ratingEntity.setFilm(filmEntity);
        ratingEntity.setUser(userEntity);

        RatingEntity savedRating = ratingRepository.save(ratingEntity);

        return modelMapper.map(savedRating, RatingDto.class);
    }

    @Override
    public RatingDto getRating(UUID id) {
        RatingEntity ratingEntity = ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));

        return modelMapper.map(ratingEntity, RatingDto.class);
    }

    @Override
    public List<RatingDto> getAllRatingByUserId(UUID id) {
        List<RatingEntity> ratingEntities = ratingRepository.getAllRatingByUserId(id.toString());
        if (ratingEntities == null) {
            throw new ResourceNotFoundException("Resource not found");
        }
        return ratingEntities.stream().map(ratingEntity -> {
            return modelMapper.map(ratingEntity, RatingDto.class);
        }).collect(Collectors.toList());
    }

    @Override
    public RatingDto updateRating(UUID id, RatingDto ratingDto) {
        RatingEntity ratingEntity = modelMapper.map(ratingDto, RatingEntity.class);
        RatingEntity newRating = ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));

        BeanUtils.copyProperties(ratingEntity, newRating, Utils.getNullPropertyNames(ratingEntity));

        if (ratingDto.getFilmId() != null) {
            FilmEntity filmEntity = filmRepository.findById(UUID.fromString(ratingDto.getFilmId())).orElseThrow(() -> new ResourceNotFoundException("'" + ratingDto.getFilmId() + "'"));
            newRating.setFilm(filmEntity);
        }
        if (ratingDto.getUserId() != null) {
            UserEntity userEntity = userRepository.findById(UUID.fromString(ratingDto.getUserId())).orElseThrow(() -> new ResourceNotFoundException("'" + ratingDto.getUserId() + "'"));
            newRating.setUser(userEntity);
        }
        RatingEntity savedRating = ratingRepository.save(newRating);
        return modelMapper.map(savedRating, RatingDto.class);
    }

    @Override
    public Map<String, Map<String, Object>> getTotalRatingByFilmIdAndRatingType(UUID id) {
        List<Object[]> ratings = ratingRepository.getotalRatingsByFilmIdAndRatingType(String.valueOf(id));
        if(ratings.isEmpty()){
            throw new ResourceNotFoundException("No ratings found for film:" + id);
        }
        Map<String, Map<String, Object> > results = new HashMap<>();
        Map<String, Object> valuesSuperRatings = new HashMap<>();
        Map<String, Object> valuesCommonRatings = new HashMap<>();

        valuesSuperRatings.put("positive", ratings.get(0)[0]);
        valuesSuperRatings.put("neutral", ratings.get(0)[1]);
        valuesSuperRatings.put("negative", ratings.get(0)[2]);

        valuesCommonRatings.put("positive", ratings.get(0)[3]);
        valuesCommonRatings.put("neutral", ratings.get(0)[4]);
        valuesCommonRatings.put("negative", ratings.get(0)[5]);

        results.put("SuperRatings", valuesSuperRatings);
        results.put("CommonRatings", valuesCommonRatings);
        return results;
    }

    @Override
    public void deleteRating(UUID id) {
        ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        ratingRepository.deleteById(id);
    }
}
