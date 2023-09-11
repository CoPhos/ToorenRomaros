package com.ToorenRomaros.api.models;

import java.time.LocalDate;

public class User {

    private String username;
    private LocalDate followDate;

    public LocalDate getFollowDate() {
        return followDate;
    }

    public void setFollowDate(LocalDate followDate) {
        this.followDate = followDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
