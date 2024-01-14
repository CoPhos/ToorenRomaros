package com.ToorenRomaros.api.dto.film;

import java.time.LocalDate;

public class GetDynamicQueryMovieDto extends GetDynamicQyeryFilmDto{
    private LocalDate theatersReleaseDate;
    private Boolean atTheaters;
    public LocalDate getTheatersReleaseDate() {
        return theatersReleaseDate;
    }
    public void setTheatersReleaseDate(LocalDate theatersReleaseDate) {
        this.theatersReleaseDate = theatersReleaseDate;
    }
    public Boolean getAtTheaters() {
        return atTheaters;
    }
    public void setAtTheaters(Boolean atTheaters) {
        this.atTheaters = atTheaters;
    }
}
