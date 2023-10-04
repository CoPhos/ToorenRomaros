package com.ToorenRomaros.api.dto.user;

import java.util.UUID;

public class UserAddFollowerOrFollowingRequestDto {
    private String userId;
    private String toFollowId;

    private String type;

    public String getUserId() {
        return userId;
    }

    public String getToFollowId() {
        return toFollowId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setToFollowId(String toFollowId) {
        this.toFollowId = toFollowId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
