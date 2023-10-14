package com.ToorenRomaros.api.entities.film;

import com.ToorenRomaros.api.entities.staff.StaffFilmEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "film")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="film_type",
        discriminatorType = DiscriminatorType.INTEGER)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class FilmEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "TITTLE", columnDefinition = "VARCHAR(255)")
    @Size(max = 255, message = "max size is 255 characters")
    private String tittle;
    @Column(name = "SYNOPSIS", columnDefinition = "VARCHAR(255)")
    @Size(max = 255, message = "max size is 255 characters")
    private String synopsis;
    @Column(name = "ORIGINAL_LANGUAGE", columnDefinition = "VARCHAR(3)")
    @Size(max = 3, message = "max size is 3 characters")
    private String originalLanguage;
    @Column(name = "DISTRIBUTOR", columnDefinition = "VARCHAR(50)")
    @Size(max = 50, message = "max size is 50 characters")
    private String distributor;
    @Column(name = "SUITABLE_FOR", columnDefinition = "VARCHAR(5)")
    @Size(max = 5, message = "max size is 5 characters")
    private String suitableFor;
    @Column(name = "STREAMING_RELEASE_DATE", columnDefinition = "DATE")
    private LocalDate streamingReleaseDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PREQUEL_ID", referencedColumnName = "id")
    private FilmEntity prequel;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "SEQUEL_ID", referencedColumnName = "id")
    private FilmEntity sequel;

    //TODO: add saga relationship

    public FilmEntity() {
    }

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
    public void setStreamingReleaseDate(LocalDate streamingReleaseDate) {
        this.streamingReleaseDate = streamingReleaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmEntity that = (FilmEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
