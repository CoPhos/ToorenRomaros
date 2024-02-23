package com.ToorenRomaros.api.dto.genre;

import javax.validation.constraints.NotNull;

public class CreateGenreFilmDto {
    @NotNull(message = "Film id can not be null")
    private String film;
    @NotNull(message = "Genre id can not be null")
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
