package com.ToorenRomaros.api.entities.film;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("1")
public class Movie extends FilmEntity {
    @Column(name = "BOX_OFFICE", columnDefinition = "VARCHAR(15)")
    @Size(max = 15, message = "max size is 15 characters")
    private String boxOffice;
    @Column(name = "RUNTIME", columnDefinition = "VARCHAR(5)")
    @Size(max = 5, message = "max size is 5 characters")
    private String runTime;
    @Column(name = "THEATERS_RELEASE_DATE", columnDefinition = "DATE")
    private LocalDate theatersReleaseDate;
    @Column(name = "AT_THEATERS", columnDefinition = "Boolean")
    private Boolean atTheaters;
    public String getBoxOffice() {
        return boxOffice;
    }
    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }
    public String getRunTime() {
        return runTime;
    }
    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }
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
