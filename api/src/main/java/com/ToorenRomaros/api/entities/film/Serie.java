package com.ToorenRomaros.api.entities.film;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@DiscriminatorValue("2")

public class Serie extends FilmEntity {
    @Column(name = "SEASON_NUMBER", columnDefinition = "VARCHAR(4)")
    private String seasonNumber;

    public Serie(int filmType, UUID id, String tittle, String synopsis, String originalLanguage, String distributor, String suitableFor, LocalDate streamingReleaseDate, LocalDate coomingSoon, int averageSuperRating, int averageUserRating, SagaEntity saga, Long viewCount, String aspectRatio, String soundMix, String criticsConsensus, LocalDate addedDate, String seasonNumber) {
        super(filmType, id, tittle, synopsis, originalLanguage, distributor, suitableFor, streamingReleaseDate, coomingSoon, averageSuperRating, averageUserRating, saga, viewCount, aspectRatio, soundMix, criticsConsensus, addedDate);
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
