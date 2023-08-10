package com.ToorenRomaros.api.entities.publication;

import com.ToorenRomaros.api.entities.User;
import com.ToorenRomaros.api.entities.film.Film;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private Integer likeCount;
    private String content;
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "film")
    private Film film;
    public void setRaiting(Film film) { this.film = film;
    }

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user")
    private User user;
    public void setUser(User user) { this.user = user;
    }
}
