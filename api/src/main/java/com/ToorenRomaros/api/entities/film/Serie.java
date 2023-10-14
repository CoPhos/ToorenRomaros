package com.ToorenRomaros.api.entities.film;

import javax.persistence.*;

@Entity
@DiscriminatorValue("2")

public class Serie extends FilmEntity {
    @Column(name = "SEASON_NUMBER", columnDefinition = "VARCHAR(4)")
    private String seasonNumber;

    public String getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
