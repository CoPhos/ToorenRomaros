package com.ToorenRomaros.api.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "USERNAME")
    @Basic(optional = false)
    private String username;

    @Past
    @Column(name = "BIRTHDAY")
    @Past(message = "birthday must be past")
    private LocalDate birthday;
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

    @OneToMany(mappedBy = "follower",fetch = FetchType.LAZY)
    @Column(name = "FOLLOWER_ID")
    private List<UserFollowerEntity> followers;

    @OneToMany(mappedBy = "following",fetch = FetchType.LAZY)
    @Column(name = "USER_ID")
    private List<UserFollowerEntity> followings;

    public UserEntity(String username, LocalDate birthday, LocalDate createdDate, String about, Integer followingCount, Integer followmeCount, List<UserFollowerEntity> followers, List<UserFollowerEntity> followings) {
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.about = about;
        this.followingCount = followingCount;
        this.followmeCount = followmeCount;
        this.followers = followers;
        this.followings = followings;
    }

    public UserEntity() {
    }

//    public void addFollower(UserEntity userEntity) {
//        this.followers.add(userEntity);
//
//        if (!userEntity.getFollowers().contains(this)) {
//            followers.add(this);
//        }
//    }
//
//    public void addFollowing(UserEntity userEntity) {
//        this.followings.add(userEntity);
//
//        if (!userEntity.getFollowings().contains(this)) {
//            followings.add(this);
//        }
//    }
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

    public List<UserFollowerEntity> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserFollowerEntity> followers) {
        this.followers = followers;
    }

    public List<UserFollowerEntity> getFollowings() {
        return followings;
    }

    public void setFollowings(List<UserFollowerEntity> followings) {
        this.followings = followings;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity user = (UserEntity) o;
        return Objects.equals(getId(), user.getId());
    }
}