package com.ToorenRomaros.api.dto.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserDto {
    private String id;
    private String username;
    private LocalDate birthday;
    private LocalDate createdDate;
    private String about;
    private Integer followingCount;
    private Integer followmeCount;
//    private List<UserFollowerDto> followers;
//    private List<UserFollowerDto> followings;


    public UserDto(String username, LocalDate birthday, LocalDate createdDate, String about, Integer followingCount, Integer followmeCount) {
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.about = about;
        this.followingCount = followingCount;
        this.followmeCount = followmeCount;
    }

    public UserDto(String id, String username, LocalDate birthday, LocalDate createdDate, String about, Integer followingCount, Integer followmeCount) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.about = about;
        this.followingCount = followingCount;
        this.followmeCount = followmeCount;
    }

    public UserDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

}
