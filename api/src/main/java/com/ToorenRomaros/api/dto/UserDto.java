package com.ToorenRomaros.api.dto;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.modelmapper.PropertyMap;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.data.projection.EntityProjection.ProjectionType.DTO;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserDto {
    private UUID id;
    private String username;
    private LocalDate birthday;
    private LocalDate createdDate;
    /*private byte[] photo;*/
    private String about;
    private Integer followingCount;
    private Integer followmeCount;
    private List<UserFollowerDto> followers;
    private List<UserFollowerDto> followings;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public Integer getFollowmeCount() {
        return followmeCount;
    }

    public void setFollowmeCount(Integer followmeCount) {
        this.followmeCount = followmeCount;
    }

    public List<UserFollowerDto> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserFollowerDto> followers) {
        this.followers = followers;
    }

    public List<UserFollowerDto> getFollowings() {
        return followings;
    }

    public void setFollowings(List<UserFollowerDto> followings) {
        this.followings = followings;
    }
}
