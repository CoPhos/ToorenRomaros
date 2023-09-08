package com.ToorenRomaros.api.entities;

import com.ToorenRomaros.api.entities.publication.PublicationEntity;
import com.ToorenRomaros.api.entities.publication.RatingEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public UserEntity(String username, LocalDate birthday, LocalDate createdDate, String about, Integer followingCount, Integer followmeCount, Set<UserEntity> followers, List<PublicationEntity> publicationEntities, List<RatingEntity> ratings) {
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.about = about;
        this.followingCount = followingCount;
        this.followmeCount = followmeCount;
        this.followers = followers;
//        this.publicationEntities = publicationEntities;
//        this.ratings = ratings;
    }
    public UserEntity(){}

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

    public Set<UserEntity> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<UserEntity> followers) {
        this.followers = followers;
    }
//    public List<PublicationEntity> getPublications() {
//        return publicationEntities;
//    }
//
//    public List<PublicationEntity> getPublicationEntities() {
//        return publicationEntities;
//    }
//
//    public void setPublicationEntities(List<PublicationEntity> publicationEntities) {
//        this.publicationEntities = publicationEntities;
//    }
//
//    public void setPublications(List<PublicationEntity> publicationEntities) {
//        this.publicationEntities = publicationEntities;
//    }
    @JsonIgnore
    @OneToMany(mappedBy = "followers")
    private Set<UserEntity> followers  = new HashSet<>();

    //later
//    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
//    private List<PublicationEntity> publicationEntities;
//    public List<PublicationEntity> getPublication() { return publicationEntities;
//    }
//    public void setPublication(List<PublicationEntity> publicationEntities) { this.publicationEntities = publicationEntities;
//    }
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
//    private List<RatingEntity> ratings;
//    public List<RatingEntity> getRatings() { return ratings;
//    }
//    public void setRatings(List<RatingEntity> ratings) { this.ratings = ratings;
//    }
}
