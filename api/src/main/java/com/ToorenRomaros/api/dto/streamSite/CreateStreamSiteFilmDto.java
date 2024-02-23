package com.ToorenRomaros.api.dto.streamSite;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class CreateStreamSiteFilmDto {
    @NotNull(message = "Url can not be null")
    @Size(max = 255, message = "max size is 255 characters")
    private String url;
    @NotNull(message = "rent can not be null")
    private Boolean rent;
    @NotNull(message = "Buy can not be null")
    private Boolean buy;
    private String filmId;
    private String streamsiteId;

    public String getStreamsiteId() {
        return streamsiteId;
    }

    public void setStreamsiteId(String streamsiteId) {
        this.streamsiteId = streamsiteId;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getRent() {
        return rent;
    }

    public void setRent(Boolean rent) {
        this.rent = rent;
    }

    public Boolean getBuy() {
        return buy;
    }

    public void setBuy(Boolean buy) {
        this.buy = buy;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }
}
