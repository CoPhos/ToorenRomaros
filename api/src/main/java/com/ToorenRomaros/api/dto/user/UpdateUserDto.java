package com.ToorenRomaros.api.dto.user;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

public class UpdateUserDto {

    private UUID id;
    @Size(max = 32, message = "username max size is 32 characters")
    private String username;
    @Past(message = "birthday must be past")
    private LocalDate birthday;
    @FutureOrPresent
    private LocalDate createdDate;
    @Size(max = 255, message = "About max size is 255 characters")
    private String about;
    @PositiveOrZero(message = "following me count can not be negative")
    private Integer followingCount;
    @PositiveOrZero(message = "following count can not be negative")
    private Integer followmeCount;

    public UpdateUserDto() {
    }

    public UpdateUserDto(UUID id, String username, LocalDate birthday, LocalDate createdDate, String about, Integer followingCount, Integer followmeCount) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.about = about;
        this.followingCount = followingCount;
        this.followmeCount = followmeCount;
    }

    public UpdateUserDto(UUID id, String username, LocalDate birthday, LocalDate createdDate) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
    }
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
}
