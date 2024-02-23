package com.ToorenRomaros.api.dto.genre;

import javax.validation.constraints.NotNull;

public class UpdateGenreFilmDto {
    private String film;
    private String genre;

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
