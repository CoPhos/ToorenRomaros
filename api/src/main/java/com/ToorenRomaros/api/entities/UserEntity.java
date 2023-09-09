package com.ToorenRomaros.api.entities;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true)
    @NotNull(message = "User name is required.")
    @Basic(optional = false)
    private String username;

    @Past
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;
    @FutureOrPresent
    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;
    /*@Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;*/
    @Column(name = "ABOUT")
    private String about;
    @PositiveOrZero
    @Column(name = "FOLLOWING_COUNT")
    private Integer followingCount;
    @PositiveOrZero
    @Column(name = "FOLLOWING_ME_COUNT")
    private Integer followmeCount;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "USER_FOLLOWER",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FOLLOWER_ID")
    )
    private List<UserEntity> followers = Collections.emptyList();

    @ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY)
    private List<UserEntity> user;

    public UserEntity(String username, LocalDate birthday, LocalDate createdDate, String about, Integer followingCount, Integer followmeCount) {
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.about = about;
        this.followingCount = followingCount;
        this.followmeCount = followmeCount;
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

    public List<UserEntity> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserEntity> followers) {
        this.followers = followers;
    }

    public List<UserEntity> getUser() {
        return user;
    }

    public void setUser(List<UserEntity> user) {
        this.user = user;
    }

}