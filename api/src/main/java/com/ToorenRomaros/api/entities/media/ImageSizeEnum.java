package com.ToorenRomaros.api.entities.media;

public enum ImageSizeEnum {
    THREE_DPI("3DPI"),
    TWO_DPI("2DPI"),
    ONE_DPI("1DPI");

    private final String label;

    ImageSizeEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
