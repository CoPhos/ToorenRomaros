package com.ToorenRomaros.api.dto.publication;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public class UpdatePostDto {
    @FutureOrPresent(message = "Publication date can not be past")
    private LocalDateTime publicationDateTime;
    @Min(value = 0, message = "Like count can not be negative")
    private int likeCount;
    private String tittle;
    private String synthesis;
    private String tag;
    private String status;
    private String content;
    private String headline;
    private boolean isReview;

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
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
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
}
