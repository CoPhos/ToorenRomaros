package com.ToorenRomaros.api.dto.film;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "filmType",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateMovieDto.class, name = "1"),
        @JsonSubTypes.Type(value = CreateSerieDto.class, name = "2"),
})
public class GetDynamicQyeryFilmDto {
    private String id;
    private String tittle;
    private LocalDate coomingSoon;
    private LocalDate streamingReleaseDate;
    private Integer filmType;
    private Float averageSuperRating;
    private Float averageUserRating;
    private Long viewCount;
    private String mainImageId;

    public String getMainImageId() {
        return mainImageId;
    }
    public void setMainImageId(String mainImageId) {
        this.mainImageId = mainImageId;
    }
    public Long getViewCount() {
        return viewCount;
    }
    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
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
}
