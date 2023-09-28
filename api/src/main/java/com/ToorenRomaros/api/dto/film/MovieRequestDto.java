package com.ToorenRomaros.api.dto.film;

import javax.validation.constraints.Size;
import java.time.LocalDate;

public class MovieRequestDto {
    private String id;
    @Size(max = 255, message = "Tittle max size is 255 characters.")
    private String tittle;
    @Size(max = 255, message = "Synopsis max size is 255 characters.")
    private String synopsis;
    @Size(max = 3, message = "Original language max size is 3 characters.")
    private String originalLanguage;
    @Size(max = 50, message = "Distributor max size is 50 characters.")
    private String distributor;
    @Size(max = 5, message = "Suitable for max size is 5 characters")
    private String suitableFor;
    private LocalDate streamingReleaseDate;
    private String prequel;
    private String sequel;
    private String sagaName;
    @Size(max = 15, message = "Box office max size is 15 characters")
    private String boxOffice;
    @Size(max = 5, message = "Run time max size is 5 characters")
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

    public String getPrequel() {
        return prequel;
    }

    public void setPrequel(String prequel) {
        this.prequel = prequel;
    }

    public String getSequel() {
        return sequel;
    }

    public void setSequel(String sequel) {
        this.sequel = sequel;
    }

    public String getSagaName() {
        return sagaName;
    }

    public void setSagaName(String sagaName) {
        this.sagaName = sagaName;
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
