package com.ToorenRomaros.api.dto.user;

import java.util.UUID;

public class UserAddFollowerOrFollowingRequestDto {
    private String userId;
    private String toFollowId;

    public String getUserId() {
        return userId;
    }

    public String getToFollowId() {
        return toFollowId;
    }
}