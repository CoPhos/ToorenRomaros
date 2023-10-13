package com.ToorenRomaros.api.dto.streamSite;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class StreamSiteDto {

    private UUID id;
    @NotNull(message = "Stream site name can not be null")
    private String name;
    @NotNull(message = "Price can not be null")
    private String price;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
