package com.ToorenRomaros.api.entities.streamSite;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "stream_film")
public class StreamSiteFilmEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "URL", columnDefinition = "VARCHAR(255)")
    @NotNull(message = "Url can not be null")
    private String url;
    @Column(name = "RENT", columnDefinition = "Boolean")
    @NotNull(message = "rent can not be null")
    private Boolean rent;
    @Column(name = "BUY", columnDefinition = "Boolean")
    @NotNull(message = "Buy can not be null")
    private Boolean buy;

    @ManyToOne
    @JoinColumn(name = "film_id")
    FilmEntity film;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    StreamSiteEntity streamSite;

    public StreamSiteFilmEntity(String url, Boolean rent, Boolean buy, FilmEntity film, StreamSiteEntity streamSite) {
        this.url = url;
        this.rent = rent;
        this.buy = buy;
        this.film = film;
        this.streamSite = streamSite;
    }

    public StreamSiteFilmEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getRent() {
        return rent;
    }

    public void setRent(Boolean rent) {
        this.rent = rent;
    }

    public Boolean getBuy() {
        return buy;
    }

    public void setBuy(Boolean buy) {
        this.buy = buy;
    }

    public FilmEntity getFilm() {
        return film;
    }

    public void setFilm(FilmEntity film) {
        this.film = film;
    }

    public StreamSiteEntity getStreamSite() {
        return streamSite;
    }

    public void setStreamSite(StreamSiteEntity streamSite) {
        this.streamSite = streamSite;
    }
}
