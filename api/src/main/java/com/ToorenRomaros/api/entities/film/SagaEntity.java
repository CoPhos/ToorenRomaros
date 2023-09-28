package com.ToorenRomaros.api.entities.film;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

@Entity
public class SagaEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "NAME", columnDefinition = "VARCHAR(255)")
    @Size(max = 255, message = "max size is 255 characters")
    private String name;

    public SagaEntity(String name, FilmEntity film) {
        this.name = name;
        this.film = film;
    }

    @ManyToOne
    @JoinColumn(name="FILM_ID", nullable=false)
    private FilmEntity film;

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
    public FilmEntity getFilm() {
        return film;
    }
    public void setFilm(FilmEntity film) {
        this.film = film;
    }

}
