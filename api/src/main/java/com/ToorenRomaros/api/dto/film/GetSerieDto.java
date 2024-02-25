package com.ToorenRomaros.api.dto.film;

public class GetSerieDto  extends GetFilmDto {
    private String seasonNumber;
    public String getSeasonNumber() {
        return seasonNumber;
    }
    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
