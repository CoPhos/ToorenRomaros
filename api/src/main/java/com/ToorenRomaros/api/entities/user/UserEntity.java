package com.ToorenRomaros.api.entities.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
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
    @Column(name = "USERNAME", unique = true, nullable = false, columnDefinition = "VARCHAR(32)")
    //@Basic(optional = false)
    @Size(max = 32, message = "username max size is 32 characters")
    private String username;
    @Past(message = "birthday must be past")
    @Column(name = "BIRTHDAY", columnDefinition = "DATE")
    private LocalDate birthday;
    @FutureOrPresent
    @Column(name = "CREATED_DATE", columnDefinition = "DATE")
    private LocalDate createdDate;
    @Column(name = "ABOUT", columnDefinition = "VARCHAR(255)")
    @Size(max = 255, message = "About max size is 255 characters")
    private String about;
    @PositiveOrZero(message = "following count can not be negative")
    @Column(name = "FOLLOWING_COUNT")
    private Integer followingCount;
    @PositiveOrZero(message = "following me count can not be negative")
    @Column(name = "FOLLOWING_ME_COUNT")
    private Integer followmeCount;


    public UserEntity(String username, LocalDate birthday, LocalDate createdDate, String about, Integer followingCount, Integer followmeCount) {
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.about = about;
        this.followingCount = followingCount;
        this.followmeCount = followmeCount;
    }

    public UserEntity(UUID id, String username, LocalDate birthday, LocalDate createdDate, String about, Integer followingCount, Integer followmeCount) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.about = about;
        this.followingCount = followingCount;
        this.followmeCount = followmeCount;
    }

    public UserEntity(UUID id, String username, LocalDate birthday, LocalDate createdDate) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.createdDate = createdDate;
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
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}