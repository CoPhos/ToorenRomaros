package com.ToorenRomaros.api.dto.film;

import com.ToorenRomaros.api.entities.film.FilmEntity;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class MovieDto {

    private String id;
    private String tittle;
    private String synopsis;
    private String originalLanguage;
    private String distributor;
    private String suitableFor;
    private LocalDate streamingReleaseDate;
    private FilmEntity prequel;
    private FilmEntity sequel;
    private List<SagaDto> Saga;
    private String boxOffice;
    private String runTime;
    private LocalDate theatersReleaseDate;

    private Boolean atTheaters;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getSuitableFor() {
        return suitableFor;
    }

    public void setSuitableFor(String suitableFor) {
        this.suitableFor = suitableFor;
    }

    public LocalDate getStreamingReleaseDate() {
        return streamingReleaseDate;
    }

    public void setStreamingReleaseDate(LocalDate streamingReleaseDate) {
        this.streamingReleaseDate = streamingReleaseDate;
    }
    public FilmEntity getPrequel() {
        return prequel;
    }

    public void setPrequel(FilmEntity prequel) {
        this.prequel = prequel;
    }

    public FilmEntity getSequel() {
        return sequel;
    }

    public void setSequel(FilmEntity sequel) {
        this.sequel = sequel;
    }

    public List<SagaDto> getSaga() {
        return Saga;
    }

    public void setSaga(List<SagaDto> saga) {
        Saga = saga;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public LocalDate getTheatersReleaseDate() {
        return theatersReleaseDate;
    }

    public void setTheatersReleaseDate(LocalDate theatersReleaseDate) {
        this.theatersReleaseDate = theatersReleaseDate;
    }

    public Boolean getAtTheaters() {
        return atTheaters;
    }

    public void setAtTheaters(Boolean atTheaters) {
        this.atTheaters = atTheaters;
    }
}
