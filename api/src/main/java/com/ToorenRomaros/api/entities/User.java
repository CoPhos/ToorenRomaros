package com.ToorenRomaros.api.entities;

import com.ToorenRomaros.api.entities.publication.Publication;
import com.ToorenRomaros.api.entities.publication.Rating;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class User {
    @Id
    private String username;
    private LocalDate birthday;
    private LocalDate createdDate;
    /*@Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;*/
    private String about;
    private Integer followingCount, followmeCount;

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

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "following")
    private List<User> followers;
    @JoinTable(name = "followers",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "follower_id")})
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> following;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Publication> publications;
    public List<Publication> getPublication() { return publications;
    }
    public void setPublication(List<Publication> publications) { this.publications = publications;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Rating> ratings;
    public List<Rating> getRatings() { return ratings;
    }
    public void setRatings(List<Rating> ratings) { this.ratings = ratings;
    }
}
