package com.ToorenRomaros.api.dto.user;

import java.time.LocalDate;

public class UserFollowerDto {
    private String user;
    private String follower;
    private LocalDate followDate;

    public UserFollowerDto(String follower, LocalDate followDate) {
        this.follower = follower;
        this.followDate = followDate;
    }

    public UserFollowerDto() {
    }

    public String getFollower() {
        return follower;
    }
    public void setFollower(String follower) {
        this.follower = follower;
    }
    public LocalDate getFollowDate() {
        return followDate;
    }
    public void setFollowDate(LocalDate followDate) {
        this.followDate = followDate;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
}
