package com.ToorenRomaros.api.entities;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true)
    @NotNull(message = "Username is required.")
    @Basic(optional = false)
    private String username;

    @Past
    @Column(name = "BIRTHDAY")
    @Past(message = "birthday must be past")
    private LocalDate birthday;
    @FutureOrPresent(message = "created date must be future or present")
    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;
    /*@Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;*/
    @Column(name = "ABOUT")
    private String about;
    @PositiveOrZero(message = "following count can not be negative")
    @Column(name = "FOLLOWING_COUNT")
    private Integer followingCount;
    @PositiveOrZero(message = "following me count can not be negative")
    @Column(name = "FOLLOWING_ME_COUNT")
    private Integer followmeCount;

    @OneToMany(mappedBy = "follower")
    private List<UserEntity> follower;

    @OneToMany(mappedBy = "user")
    private List<UserEntity> user;

    public UserEntity(String username, LocalDate birthday, LocalDate createdDate, String about, Integer followingCount, Integer followmeCount, List<UserEntity> follower, List<UserEntity> user) {
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.about = about;
        this.followingCount = followingCount;
        this.followmeCount = followmeCount;
        this.follower = follower;
        this.user = user;
    }

    public UserEntity() {
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

    public List<UserEntity> getFollower() {
        return follower;
    }

    public void setFollower(List<UserEntity> follower) {
        this.follower = follower;
    }

    public List<UserEntity> getUser() {
        return user;
    }

    public void setUser(List<UserEntity> user) {
        this.user = user;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity book = (UserEntity) o;
        return Objects.equals(getUsername(), book.getUsername());
    }
}