package com.ToorenRomaros.api.entities.genre;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "genre_film")
public class GenreFilmEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "film_id")
    FilmEntity film;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    GenreEntity genre;
    public GenreFilmEntity(FilmEntity film, GenreEntity genre) {
        this.film = film;
        this.genre = genre;
    }
    public GenreFilmEntity() {
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public FilmEntity getFilm() {
        return film;
    }
    public void setFilm(FilmEntity film) {
        this.film = film;
    }
    public GenreEntity getGenre() {
        return genre;
    }
    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }
}
