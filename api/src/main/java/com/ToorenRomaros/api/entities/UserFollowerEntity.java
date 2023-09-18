package com.ToorenRomaros.api.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_follower")
public class UserFollowerEntity {

    @Id
    @Column(name = "ID", columnDefinition = "VARCHAR(36)",updatable = false, nullable = false)
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;


    @PastOrPresent
    @Column(name = "FOLLOW_SINCE")
    private LocalDate followDate;

    @ManyToOne
    @Type(type="uuid-char")
    @JoinColumn(name = "FOLLOWER_ID", columnDefinition = "VARCHAR(36)", nullable = false)
    private UserEntity follower;

    @ManyToOne
    @Type(type="uuid-char")
    @JoinColumn(name = "USER_ID", columnDefinition = "VARCHAR(36)", nullable = false)
    private UserEntity user;

    public UserFollowerEntity() {

    }

    public LocalDate getFollowDate() {
        return followDate;
    }

    public void setFollowDate(LocalDate followDate) {
        this.followDate = followDate;
    }

    public UserEntity getFollower() {
        return follower;
    }

    public void setFollower(UserEntity follower) {
        this.follower = follower;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
