package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.genre.GenreEntity;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MyQuery {
    private String tittle;
    @ManyToOne
    @JoinColumn(name = "film_id")
    FilmEntity film;
    @ManyToOne
    @JoinColumn(name = "stream_id")
    StreamSiteEntity streamSite;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    GenreEntity genre;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
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

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }
}
