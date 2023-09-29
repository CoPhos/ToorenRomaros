package com.ToorenRomaros.api.entities.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name = "user_follower")
public class UserFollowerEntity {

    @Id
    @Column(name = "ID", columnDefinition = "VARCHAR(36)",updatable = false, nullable = false)
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @PastOrPresent
    @Column(name = "FOLLOW_SINCE", columnDefinition = "DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy/dd/mm")
    private LocalDate followDate;

    @ManyToOne
    @Type(type="uuid-char")
    @JoinColumn(name = "FOLLOWER_ID", nullable = false)
    private UserEntity follower;

    @ManyToOne
    @Type(type="uuid-char")
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity user;

    public UserFollowerEntity(LocalDate followDate, UserEntity follower, UserEntity user) {
        this.followDate = followDate;
        this.follower = follower;
        this.user = user;
    }

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
