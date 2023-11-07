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
@Table(name = "discuss")
public class DiscussEntity{
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "BODY", columnDefinition = "VARCHAR(255)")
    @NotNull(message = "Body can not be null")
    private String body;
    @Column(name = "PUBLICATION_DATETIME", columnDefinition = "DATETIME")
    @FutureOrPresent(message = "Publication date can not be past")
    private LocalDateTime publicationDateTime;
    @Column(name = "LIKE_COUNT", columnDefinition = "VARCHAR(10) DEFAULT 0")
    @Min(value = 0, message = "Like count can not be negative")
    private int likeCount;
    @Column(name = "REPORTED", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean reported;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;
//  @Formula("()")
//  private String subDiscussCount;
}