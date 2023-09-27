package com.ToorenRomaros.api.dto.film;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

public class SagaDto {
    private String name;
    private String film;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }
}
