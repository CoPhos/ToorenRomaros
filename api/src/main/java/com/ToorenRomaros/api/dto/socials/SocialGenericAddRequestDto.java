package com.ToorenRomaros.api.dto.socials;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class SocialGenericAddRequestDto {
    private UUID id;
    @NotNull(message = "Url can not be null")
    private String url;
    @NotNull(message = "Generic Id can not be null")
    private String genericId;
    @NotNull(message = "Social Id can not be null")
    private String socialId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGenericId() {
        return genericId;
    }

    public void setGenericId(String genericId) {
        this.genericId = genericId;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }
}
