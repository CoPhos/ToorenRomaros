package com.ToorenRomaros.api.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String tittle, synopsis, originalLanguage, runtime, distributor, boxOffice, suitableFor;
    private LocalDate theatersRelease, streamingRelease;
    /*@Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;*/
    private Boolean atTheaters;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getSuitableFor() {
        return suitableFor;
    }

    public void setSuitableFor(String suitableFor) {
        this.suitableFor = suitableFor;
    }

    public LocalDate getTheatersRelease() {
        return theatersRelease;
    }

    public void setTheatersRelease(LocalDate theatersRelease) {
        this.theatersRelease = theatersRelease;
    }

    public LocalDate getStreamingRelease() {
        return streamingRelease;
    }

    public void setStreamingRelease(LocalDate streamingRelease) {
        this.streamingRelease = streamingRelease;
    }

    public Boolean getAtTheaters() {
        return atTheaters;
    }

    public void setAtTheaters(Boolean atTheaters) {
        this.atTheaters = atTheaters;
    }
}
