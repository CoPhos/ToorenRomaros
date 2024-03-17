package com.ToorenRomaros.api.dto.publication;

import java.time.LocalDateTime;

public class GetPostDto {
    private String id;
    private LocalDateTime publicationDateTime;
    private int likeCount;
    private String tittle;
    private String synthesis;
    private String user;
    private String tag;
    private String film;
    private String status;
    private String content;
    private String headline;
    private boolean isReview;
    private String mainImageId;
    private String tagId;
    private boolean liked;
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getMainImageId() {
        return mainImageId;
    }

    public void setMainImageId(String mainImageId) {
        this.mainImageId = mainImageId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
