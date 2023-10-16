package com.ToorenRomaros.api.entities.publication;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "rating",
        uniqueConstraints = @UniqueConstraint(columnNames = {"film_id", "user_id"}))
public class RatingEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "RATING", columnDefinition = "FLOAT")
    @NotNull(message = "Rating can not be null")
    @Min(value=0, message = "Rating can not be less than 0")
    @Max(value = 100, message = "Rating can not be bigger than 100")
    private float rating;
    @Column(name = "SUPER_RATING", columnDefinition = "BOOLEAN")
    @NotNull(message = "Super rating can not be null")
    private boolean superRating;

    @ManyToOne
    @JoinColumn(name = "film_id")
    FilmEntity film;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isSuperRating() {
        return superRating;
    }

    public void setSuperRating(boolean superRating) {
        this.superRating = superRating;
    }

    public FilmEntity getFilm() {
        return film;
    }

    public void setFilm(FilmEntity film) {
        this.film = film;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
