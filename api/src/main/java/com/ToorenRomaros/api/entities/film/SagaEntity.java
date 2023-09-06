package com.ToorenRomaros.api.entities.film;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class SagaEntity {
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
    private List<FilmEntity> filmEntities;
    public List<FilmEntity> getFilms() { return filmEntities;
    }
    public void setFilm(List<FilmEntity> filmEntities) { this.filmEntities = filmEntities;
    }
}
