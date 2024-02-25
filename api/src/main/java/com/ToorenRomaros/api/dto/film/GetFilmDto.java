package com.ToorenRomaros.api.dto.film;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "filmType",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateMovieDto.class, name = "1"),
        @JsonSubTypes.Type(value = CreateSerieDto.class, name = "2"),
})
public class GetFilmDto {
    private String id;
    private String tittle;
    private String synopsis;
    private String originalLanguage;
    private String distributor;
    private String suitableFor;
    private LocalDate coomingSoon;
    private LocalDate streamingReleaseDate;
    private Integer filmType;
    private String sagaId;
    private Float averageSuperRating;
    private Float averageUserRating;
    private String criticsConsensus;
    private String aspectRatio;
    private String soundMix;
    private Long viewCount;
    private LocalDate addedDate;
    private String mainImageId;

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

    public LocalDate getCoomingSoon() {
        return coomingSoon;
    }

    public void setCoomingSoon(LocalDate coomingSoon) {
        this.coomingSoon = coomingSoon;
    }

    public LocalDate getStreamingReleaseDate() {
        return streamingReleaseDate;
    }

    public void setStreamingReleaseDate(LocalDate streamingReleaseDate) {
        this.streamingReleaseDate = streamingReleaseDate;
    }

    public Integer getFilmType() {
        return filmType;
    }

    public void setFilmType(Integer filmType) {
        this.filmType = filmType;
    }

    public String getSagaId() {
        return sagaId;
    }

    public void setSagaId(String sagaId) {
        this.sagaId = sagaId;
    }

    public Float getAverageSuperRating() {
        return averageSuperRating;
    }

    public void setAverageSuperRating(Float averageSuperRating) {
        this.averageSuperRating = averageSuperRating;
    }

    public Float getAverageUserRating() {
        return averageUserRating;
    }

    public void setAverageUserRating(Float averageUserRating) {
        this.averageUserRating = averageUserRating;
    }

    public String getCriticsConsensus() {
        return criticsConsensus;
    }

    public void setCriticsConsensus(String criticsConsensus) {
        this.criticsConsensus = criticsConsensus;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public String getSoundMix() {
        return soundMix;
    }

    public void setSoundMix(String soundMix) {
        this.soundMix = soundMix;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    public String getMainImageId() {
        return mainImageId;
    }

    public void setMainImageId(String mainImageId) {
        this.mainImageId = mainImageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetFilmDto getFilmDto = (GetFilmDto) o;
        return Objects.equals(id, getFilmDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
