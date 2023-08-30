package com.ToorenRomaros.api.entities.genre;

import com.ToorenRomaros.api.entities.film.Film;
import com.ToorenRomaros.api.entities.media.Video;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Genre {
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
    private List<Film> films;

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
