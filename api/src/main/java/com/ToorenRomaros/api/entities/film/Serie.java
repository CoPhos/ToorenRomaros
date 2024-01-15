package com.ToorenRomaros.api.entities.film;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@DiscriminatorValue("2")

public class Serie extends FilmEntity {
    @Column(name = "SEASON_NUMBER", columnDefinition = "VARCHAR(4)")
    private String seasonNumber;

    public Serie(int filmType, UUID id, String tittle, String synopsis, String originalLanguage, String distributor, String suitableFor, LocalDate streamingReleaseDate, LocalDate coomingSoon, int averageSuperRating, int averageUserRating, FilmEntity prequel, FilmEntity sequel, SagaEntity saga, Long viewCount, LocalDate addedDate, String seasonNumber) {
        super(filmType, id, tittle, synopsis, originalLanguage, distributor, suitableFor, streamingReleaseDate, coomingSoon, averageSuperRating, averageUserRating, prequel, sequel, saga, viewCount, addedDate);
        this.seasonNumber = seasonNumber;
    }

    public Serie() {
    }



    public String getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
