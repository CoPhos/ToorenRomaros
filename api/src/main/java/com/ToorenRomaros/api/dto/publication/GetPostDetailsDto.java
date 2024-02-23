package com.ToorenRomaros.api.dto.publication;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.UUID;

public class GetPostDetailsDto {
    private UUID id;
    @FutureOrPresent(message = "Publication date can not be past")
    private LocalDateTime publicationDateTime;
    @Min(value = 0, message = "Like count can not be negative")
    private int likeCount;
    private String tittle;
    private String synthesis;
    private String headline;
    private boolean isReview;
    private int rating;
    private String user;
    private String tag;
    private String filmMainImageId;
    private String filmId;
    private String mainImageThreeDpi;
    private String mainImageTwoDpi;
    private String mainImageOneDpi;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMainImageThreeDpi() {
        return mainImageThreeDpi;
    }

    public void setMainImageThreeDpi(String mainImageThreeDpi) {
        this.mainImageThreeDpi = mainImageThreeDpi;
    }

    public String getMainImageTwoDpi() {
        return mainImageTwoDpi;
    }

    public void setMainImageTwoDpi(String mainImageTwoDpi) {
        this.mainImageTwoDpi = mainImageTwoDpi;
    }

    public String getMainImageOneDpi() {
        return mainImageOneDpi;
    }

    public void setMainImageOneDpi(String mainImageOneDpi) {
        this.mainImageOneDpi = mainImageOneDpi;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmMainImageId() {
        return filmMainImageId;
    }

    public void setFilmMainImageId(String filmMainImageId) {
        this.filmMainImageId = filmMainImageId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

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

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public boolean isReview() {
        return isReview;
    }

    public void setReview(boolean review) {
        isReview = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
