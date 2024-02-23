package com.ToorenRomaros.api.dto.publication;

import java.time.LocalDateTime;

public class UpdateCommentDto {
    private String body;
    private LocalDateTime publicationDateTime;
    private int likeCount;
    private boolean reported;
    private int rating;
    private boolean spoiler;

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
}
