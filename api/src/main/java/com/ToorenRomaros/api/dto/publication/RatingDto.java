package com.ToorenRomaros.api.dto.publication;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class RatingDto {
    private UUID id;
    @NotNull(message = "Rating can not be null")
    @Min(value=0, message = "Rating can not be less than 0")
    @Max(value = 100, message = "Rating can not be bigger than 100")
    private float rating;
    @NotNull(message = "Super rating can not be null")
    private boolean superRating;
   private String filmId;
   private String userId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isSuperRating() {
        return superRating;
    }

    public void setSuperRating(boolean superRating) {
        this.superRating = superRating;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
