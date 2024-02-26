package com.ToorenRomaros.api.dto.media;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class CreateImageDto {
    @NotNull
    private MultipartFile file;
    @NotNull
    private String filmType;
    @NotNull
    private String filmId;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }
}
