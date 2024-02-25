package com.ToorenRomaros.api.dto.film;

import javax.validation.constraints.Size;
import java.time.LocalDate;

public class GetMovieDto extends GetFilmDto {
    private String boxOffice;
    private String runTime;
    private LocalDate theatersReleaseDate;
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
