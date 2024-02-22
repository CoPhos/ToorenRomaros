package com.ToorenRomaros.api.dto.film;

public class UpdateSerieDto extends UpdateFilmDto {
    private String seasonNumber;
    public String getSeasonNumber() {
        return seasonNumber;
    }
    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
