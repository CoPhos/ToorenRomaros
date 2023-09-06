package com.ToorenRomaros.api.entities.genre;

import com.ToorenRomaros.api.entities.film.FilmEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String genre;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "genre_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<FilmEntity> films;

    public void setFilms(List<FilmEntity> filmEntities) {
        this.films = filmEntities;
    }
}
