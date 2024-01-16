package com.ToorenRomaros.api.entities.watchList;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.genre.GenreEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "watch_list")
public class WatchListEntity {
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
    @JoinColumn(name = "user_id")
    UserEntity user;
    @Column(name = "ADDED_DATE", columnDefinition = "DATE")
    private LocalDate addedDate= LocalDate.now();
    @Column(name = "WATCHED", columnDefinition = "Boolean")
    private boolean watched=false;

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
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    public LocalDate getAddedDate() {
        return addedDate;
    }
    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }
    public boolean isWatched() {
        return watched;
    }
    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}
