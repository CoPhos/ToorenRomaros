package com.ToorenRomaros.api.entities.publication;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.tag.TagEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "PUBLICATION_DATETIME", columnDefinition = "DATETIME")
    @FutureOrPresent(message = "Publication date can not be past")
    private LocalDateTime publicationDateTime;
    @Column(name = "LIKE_COUNT", columnDefinition = "VARCHAR(10) DEFAULT 0")
    @Min(value = 0, message = "Like count can not be negative")
    private int likeCount;
    @Column(name = "TITTLE", columnDefinition = "VARCHAR(255)")
    private String tittle;
    @Column(name = "SYNTHESIS", columnDefinition = "TEXT")
    private String synthesis;
    @Column(name = "CONTENT", columnDefinition = "LONGTEXT")
    private String content;
    @Column(name = "IS_REVIEW", columnDefinition = "Boolean")
    private boolean isReview=true;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private PostStatusEnum status;
    @Column(name = "HEADLINE", columnDefinition = "VARCHAR(255)")
    private String headline;
    @Column(name = "RATING", columnDefinition = "FLOAT")
    @NotNull(message = "Rating can not be null")
    @Min(value=0, message = "Rating can not be less than 0")
    @Max(value = 100, message = "Rating can not be bigger than 100")
    private float rating;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private FilmEntity film;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TagEntity tag;

    public PostEntity() {
    }
    public PostEntity(UUID id, float rating, LocalDateTime publicationDateTime, String synthesis, UserEntity user) {
        this.id = id;
        this.publicationDateTime = publicationDateTime;
        this.synthesis = synthesis;
        this.rating = rating;
        this.user = user;
    }

    public PostEntity(UUID id, String tittle, LocalDateTime publicationDateTime, int likeCount, String headline, UserEntity user) {
        this.id = id;
        this.publicationDateTime = publicationDateTime;
        this.likeCount = likeCount;
        this.tittle = tittle;
        this.headline = headline;
        this.user = user;
    }
    //@Formula("()")
    //private String discussCount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getPublicationDateTime() {
        return publicationDateTime;
    }

    public void setPublicationDateTime(LocalDateTime publicationDateTime) {
        this.publicationDateTime = publicationDateTime;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getSynthesis() {
        return synthesis;
    }

    public void setSynthesis(String synthesis) {
        this.synthesis = synthesis;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isReview() {
        return isReview;
    }

    public void setReview(boolean review) {
        isReview = review;
    }

    public PostStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PostStatusEnum status) {
        this.status = status;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
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

    public TagEntity getTag() {
        return tag;
    }

    public void setTag(TagEntity tag) {
        this.tag = tag;
    }
}