package com.ToorenRomaros.api.dto.streamSite;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class StreamSiteFilmDto {

    private UUID id;
    @NotNull(message = "Url can not be null")
    private String url;
    @NotNull(message = "rent can not be null")
    private Boolean rent;
    @NotNull(message = "Buy can not be null")
    private Boolean buy;
    private String filmName;
    private String streamSiteName;
    private UUID streamsiteId;

    public UUID getStreamsiteId() {
        return streamsiteId;
    }

    public void setStreamsiteId(UUID streamsiteId) {
        this.streamsiteId = streamsiteId;
    }

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

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getStreamSiteName() {
        return streamSiteName;
    }

    public void setStreamSiteName(String streamSiteName) {
        this.streamSiteName = streamSiteName;
    }
}
