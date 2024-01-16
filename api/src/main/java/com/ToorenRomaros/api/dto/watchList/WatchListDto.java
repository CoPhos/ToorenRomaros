package com.ToorenRomaros.api.dto.watchList;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public class WatchListDto {
    private String id;
    @NotNull
    private String film;
    @NotNull
    private String user;
    private LocalDate addedDate;
    private boolean watched;

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
