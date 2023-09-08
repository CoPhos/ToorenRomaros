package com.ToorenRomaros.api.entities.publication;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.film.FilmEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PublicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private Integer likeCount;
    private String content;
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "film")
    private FilmEntity film;
    public void setRaiting(FilmEntity filmEntity) { this.film = filmEntity;
    }

//    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user")
//    private UserEntity user;
//    public void setUser(UserEntity user) { this.user = user;
//    }
}
