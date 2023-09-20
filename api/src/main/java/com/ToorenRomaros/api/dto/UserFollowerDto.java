package com.ToorenRomaros.api.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
public class UserFollowerDto {
    private String follower;
    private LocalDate createdDate;

    public UserFollowerDto(String follower, LocalDate createdDate) {
        this.follower = follower;
        this.createdDate = createdDate;
    }

    public UserFollowerDto() {
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
