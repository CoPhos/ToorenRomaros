package com.ToorenRomaros.api.entities.media;

import com.ToorenRomaros.api.entities.film.FilmEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String video;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "film")
    private FilmEntity film;

    public void setFilm(FilmEntity filmEntity) { this.film = filmEntity;
    }
}
