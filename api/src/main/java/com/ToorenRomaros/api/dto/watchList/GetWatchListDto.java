package com.ToorenRomaros.api.dto.watchList;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class GetWatchListDto {
    private String id;
    @NotNull
    private String film;
    @NotNull
    private String user;
    private LocalDate addedDate;
    private boolean watched;
    private String mainImageId;
    private Float averageSuperRating;
    private Float averageUserRating;
    private String tittle;
    private LocalDate theatersReleaseDate;
    public Float getAverageSuperRating() {
        return averageSuperRating;
    }
    public void setAverageSuperRating(Float averageSuperRating) {
        this.averageSuperRating = averageSuperRating;
    }
    public Float getAverageUserRating() {
        return averageUserRating;
    }
    public void setAverageUserRating(Float averageUserRating) {
        this.averageUserRating = averageUserRating;
    }
    public String getTittle() {
        return tittle;
    }
    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
    public LocalDate getTheatersReleaseDate() {
        return theatersReleaseDate;
    }
    public void setTheatersReleaseDate(LocalDate theatersReleaseDate) {
        this.theatersReleaseDate = theatersReleaseDate;
    }
    public String getMainImageId() {
        return mainImageId;
    }
    public void setMainImageId(String mainImageId) {
        this.mainImageId = mainImageId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFilm() {
        return film;
    }
    public void setFilm(String film) {
        this.film = film;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public LocalDate getAddedDate() {
        return addedDate;
    }
    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }
    public boolean isWatched() {
        return watched;
    }
    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}
