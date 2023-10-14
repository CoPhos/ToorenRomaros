package com.ToorenRomaros.api.entities.film;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "episode")
public class EpisodeEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "TITTLE", columnDefinition = "VARCHAR(255)")
    @Size(max = 255, message = "max size is 255 characters")
    private String tittle;
    @Column(name = "STREAMING_RELEASE_DATE", columnDefinition = "DATE")
    private String airDate;
    private String runTime;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    Serie serie;

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

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}
