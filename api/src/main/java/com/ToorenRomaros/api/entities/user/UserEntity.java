package com.ToorenRomaros.api.entities.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
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
    @NotNull(message = "User name is required.")
    @Basic(optional = false)
    @Size(max = 32, message = "username max size is 32 characters")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Past(message = "birthday must be past")
    @Column(name = "BIRTHDAY", columnDefinition = "DATE")
    private LocalDate birthday;
    @FutureOrPresent
    @Column(name = "CREATED_DATE", columnDefinition = "DATE")
    private LocalDate createdDate = LocalDate.now();
    @Column(name = "ABOUT", columnDefinition = "VARCHAR(255)")
    @Size(max = 255, message = "About max size is 255 characters")
    private String about;
    @PositiveOrZero(message = "following count can not be negative")
    @Column(name = "FOLLOWING_COUNT")
    private Integer followingCount = 0;
    @PositiveOrZero(message = "following me count can not be negative")
    @Column(name = "FOLLOWING_ME_COUNT")
    private Integer followmeCount = 0;
    @Column(name = "USER_STATUS")
    private String userStatus = "ACTIVE";
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private RoleEnum role = RoleEnum.USER;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public String getUserStatus() {
        return userStatus;
    }
    public UserEntity setUserStatus(String userStatus) {
        this.userStatus = userStatus;
        return this;
    }
    public RoleEnum getRole() {
        return role;
    }
    public void setRole(RoleEnum role) {
        this.role = role;
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