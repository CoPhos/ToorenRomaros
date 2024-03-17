package com.ToorenRomaros.api.dto.publication;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public class GetCommentDto {
    private UUID id;
    private String body;
    private LocalDateTime publicationDateTime;
    private int likeCount;
    private boolean reported;
    private String userId;
    private String username;
    private String filmId;
    private int rating;
    private boolean spoiler;
    private String filmName;
    private String mainImageId;
    private String theatersReleaseDate;
    private boolean liked;

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

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isSpoiler() {
        return spoiler;
    }

    public void setSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getMainImageId() {
        return mainImageId;
    }

    public void setMainImageId(String mainImageId) {
        this.mainImageId = mainImageId;
    }

    public String getTheatersReleaseDate() {
        return theatersReleaseDate;
    }

    public void setTheatersReleaseDate(String theatersReleaseDate) {
        this.theatersReleaseDate = theatersReleaseDate;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
