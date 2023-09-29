package com.ToorenRomaros.api.dto.user;

import java.time.LocalDate;

public class UserFollowingDto {

    private String following;
    private LocalDate followDate;

    public UserFollowingDto(String following, LocalDate followDate) {
        this.following = following;
        this.followDate = followDate;
    }

    public UserFollowingDto() {
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public LocalDate getFollowDate() {
        return followDate;
    }

    public void setFollowDate(LocalDate followDate) {
        this.followDate = followDate;
    }
}
