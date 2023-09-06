package com.ToorenRomaros.api.entities;

import com.ToorenRomaros.api.entities.publication.PublicationEntity;
import com.ToorenRomaros.api.entities.publication.RatingEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    private String username;
    private LocalDate birthday;
    private LocalDate createdDate;
    /*@Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;*/
    private String about;
    private Integer followingCount, followmeCount;

    public UserEntity(String username, LocalDate birthday, LocalDate createdDate, String about, Integer followingCount, Integer followmeCount, List<UserEntity> followers, List<UserEntity> following, List<PublicationEntity> publicationEntities, List<RatingEntity> ratings) {
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.about = about;
        this.followingCount = followingCount;
        this.followmeCount = followmeCount;
        this.followers = followers;
        this.following = following;
        this.publicationEntities = publicationEntities;
        this.ratings = ratings;
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

    public List<UserEntity> getFollowing() {
        return following;
    }

    public void setFollowing(List<UserEntity> following) {
        this.following = following;
    }

    public List<PublicationEntity> getPublications() {
        return publicationEntities;
    }

    public void setPublications(List<PublicationEntity> publicationEntities) {
        this.publicationEntities = publicationEntities;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "following")
    private List<UserEntity> followers;
    @JoinTable(name = "followers",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "follower_id")})
    @ManyToMany(cascade = CascadeType.ALL)
    private List<UserEntity> following;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<PublicationEntity> publicationEntities;
    public List<PublicationEntity> getPublication() { return publicationEntities;
    }
    public void setPublication(List<PublicationEntity> publicationEntities) { this.publicationEntities = publicationEntities;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<RatingEntity> ratings;
    public List<RatingEntity> getRatings() { return ratings;
    }
    public void setRatings(List<RatingEntity> ratings) { this.ratings = ratings;
    }
}
