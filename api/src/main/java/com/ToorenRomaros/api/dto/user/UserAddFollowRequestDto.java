package com.ToorenRomaros.api.dto.user;

public class UserAddFollowRequestDto {
    private String userId;
    private String toFollowId;

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

}
