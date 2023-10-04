package com.ToorenRomaros.api.dto.film;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "filmType",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MovieDto.class, name = "1"),
        @JsonSubTypes.Type(value = SerieDto.class, name = "2"),
})
public class FilmDto {
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
    private Integer filmType;

    public Integer getFilmType() {
        return filmType;
    }
    public void setFilmType(Integer filmType) {
        this.filmType = filmType;
    }
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
}
