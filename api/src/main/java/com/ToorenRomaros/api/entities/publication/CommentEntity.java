package com.ToorenRomaros.api.entities.publication;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "comment",
        uniqueConstraints = @UniqueConstraint(columnNames = {"film_id", "user_id"}))
public class CommentEntity{
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "BODY", columnDefinition = "TEXT")
    @NotNull(message = "Body can not be null")
    private String body;
    @Column(name = "PUBLICATION_DATETIME", columnDefinition = "DATETIME")
    private LocalDateTime postDateTime;
    @Column(name = "LIKE_COUNT", columnDefinition = "VARCHAR(10) DEFAULT 0")
    @Min(value = 0, message = "Like count can not be negative")
    private int likeCount;
    @Column(name = "REPORTED", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean reported;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private FilmEntity film;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public LocalDateTime getPublicationDateTime() {
        return postDateTime;
    }
    public void setPublicationDateTime(LocalDateTime postDateTime) {
        this.postDateTime = postDateTime;
    }
    public int getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
    public boolean isReported() {
        return reported;
    }
    public void setReported(boolean reported) {
        this.reported = reported;
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    public FilmEntity getFilm() {
        return film;
    }
    public void setFilm(FilmEntity film) {
        this.film = film;
    }
}
