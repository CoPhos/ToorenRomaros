package com.ToorenRomaros.api.dto.media;

public class GetAllImagesByTypeAndOwnerIdDto {
    private String id;
    private String imageSize;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }
}
