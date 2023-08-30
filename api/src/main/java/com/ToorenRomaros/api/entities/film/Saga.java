package com.ToorenRomaros.api.entities.film;

import com.ToorenRomaros.api.entities.media.Photo;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Saga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="saga")
    private List<Film> films;
    public List<Film> getFilms() { return films;
    }
    public void setFilm(List<Film> films) { this.films = films;
    }
}
