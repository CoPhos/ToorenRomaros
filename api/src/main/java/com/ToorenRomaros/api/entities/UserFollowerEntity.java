package com.ToorenRomaros.api.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class UserFollowerEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)",updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "username")
    UserEntity user;

    @ManyToOne
    @JoinColumn(name = "username_follower")
    UserEntity followers;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserEntity getFollower() {
        return followers;
    }

    public void setFollower(UserEntity follower) {
        this.followers = follower;
    }
}
