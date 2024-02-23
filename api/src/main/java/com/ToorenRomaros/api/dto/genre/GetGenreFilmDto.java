package com.ToorenRomaros.api.dto.genre;

import javax.validation.constraints.NotNull;

public class GetGenreFilmDto {
   private String id;
    private String film;
    private String genre;

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
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
