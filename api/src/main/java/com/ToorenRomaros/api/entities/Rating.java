package com.ToorenRomaros.api.entities;

import com.ToorenRomaros.api.entities.film.Film;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private Integer rating;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "film_id")
    private Film film;
    public void setRaiting(Film film) { this.film = film;
    }
}
