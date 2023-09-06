package com.ToorenRomaros.api.entities.publication;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.film.FilmEntity;

import javax.persistence.*;

@Entity
public class RatingEntity extends PublicationEntity {
    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "filmEntity")
    private FilmEntity filmEntity;
    public void setRaiting(FilmEntity filmEntity) { this.filmEntity = filmEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user")
    private UserEntity userEntity;
    public void setUser(UserEntity userEntity) { this.userEntity = userEntity;
    }
}
