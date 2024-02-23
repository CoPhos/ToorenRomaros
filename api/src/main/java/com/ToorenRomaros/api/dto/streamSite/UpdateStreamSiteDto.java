package com.ToorenRomaros.api.dto.streamSite;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class UpdateStreamSiteDto {
    private String name;
    private String price;

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
