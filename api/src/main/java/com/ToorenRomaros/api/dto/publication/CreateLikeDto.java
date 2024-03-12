package com.ToorenRomaros.api.dto.publication;

public class CreateLikeDto {
    private String ownerId;
    private String userId;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
