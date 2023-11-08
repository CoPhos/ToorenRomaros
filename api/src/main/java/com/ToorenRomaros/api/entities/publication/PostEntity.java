package com.ToorenRomaros.api.entities.publication;

import com.ToorenRomaros.api.entities.user.UserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "PUBLICATION_DATETIME", columnDefinition = "DATETIME")
    @FutureOrPresent(message = "Publication date can not be past")
    private LocalDateTime publicationDateTime;
    @Column(name = "LIKE_COUNT", columnDefinition = "VARCHAR(10)")
    @Min(value = 0, message = "Like count can not be negative")
    private int likeCount;
    @Column(name = "TITTLE", columnDefinition = "VARCHAR(255)")
    @NotNull(message = "Tittle can not be null")
    private String tittle;
    @Column(name = "SYNTHESIS", columnDefinition = "VARCHAR(255)")
    @NotNull(message = "Synthesis can not be null")
    private String synthesis;
    @Column(name = "CONTENT", columnDefinition = "MEDIUMTEXT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    //@Formula("()")
    //private String discussCount;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getPublicationDateTime() {
        return publicationDateTime;
    }

    public void setPublicationDateTime(LocalDateTime publicationDateTime) {
        this.publicationDateTime = publicationDateTime;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getSynthesis() {
        return synthesis;
    }

    public void setSynthesis(String synthesis) {
        this.synthesis = synthesis;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}