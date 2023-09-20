package com.ToorenRomaros.api.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDateTime;
import java.util.UUID;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserFollowerDto {

    private UUID id;
    private UserDto following;
    private UserDto follower;
    private LocalDateTime createdDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserDto getFollowing() {
        return following;
    }

    public void setFollowing(UserDto user) {
        this.following = user;
    }

    public UserDto getFollower() {
        return follower;
    }

    public void setFollower(UserDto follower) {
        this.follower = follower;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
