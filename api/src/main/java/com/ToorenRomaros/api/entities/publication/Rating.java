package com.ToorenRomaros.api.entities.publication;

import com.ToorenRomaros.api.entities.User;
import com.ToorenRomaros.api.entities.film.Film;

import javax.persistence.*;

@Entity
public class Rating extends Publication{
    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "film")
    private Film film;
    public void setRaiting(Film film) { this.film = film;
    }

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user")
    private User user;
    public void setUser(User user) { this.user = user;
    }
}
