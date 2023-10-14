package com.ToorenRomaros.api.dto.film;

import com.ToorenRomaros.api.entities.film.Serie;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

public class EpisodeDto {
    private UUID id;
    @Size(max = 255, message = "max size is 255 characters")
    private String tittle;
    private String airDate;
    private String runTime;
    private String serieId;

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

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getSerieId() {
        return serieId;
    }

    public void setSerieId(String serieId) {
        this.serieId = serieId;
    }
}
