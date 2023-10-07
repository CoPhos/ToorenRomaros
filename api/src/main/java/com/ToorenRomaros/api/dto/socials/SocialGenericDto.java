package com.ToorenRomaros.api.dto.socials;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class SocialGenericDto {
    private UUID id;
    private String url;
    private String genericName;
    private String socialName;

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
    public String getGenericName() {
        return genericName;
    }
    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }
    public String getSocialName() {
        return socialName;
    }
    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }
}
