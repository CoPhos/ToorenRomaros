package com.ToorenRomaros.api.dto.genre;

import javax.validation.constraints.NotNull;

public class GenreDto {
    private String id;
    @NotNull(message = "Genre name can not be null")
    private String genre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
