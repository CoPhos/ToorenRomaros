package com.ToorenRomaros.api.dto.film;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class SerieDto extends FilmDto{
    private String seasonNumber;
    public String getSeasonNumber() {
        return seasonNumber;
    }
    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
