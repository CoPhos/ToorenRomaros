package com.ToorenRomaros.api.dto.film;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class SerieDto {

    private String id;
    private String tittle;
    private String synopsis;
    private String originalLanguage;
    private String distributor;
    private String suitableFor;
    private LocalDate streamingReleaseDate;
    private String prequel;
    private String sequel;
    private List<SagaDto> Saga;

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

    public List<SagaDto> getSaga() {
        return Saga;
    }

    public void setSaga(List<SagaDto> saga) {
        Saga = saga;
    }
}
