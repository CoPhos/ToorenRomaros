package com.ToorenRomaros.api.dto.publication;

import javax.validation.constraints.NotNull;

public class CreateLikeDto {
    @NotNull(message = "owner ID can not be null")
    private String ownerId;
    @NotNull(message = "user ID can not be null")
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
