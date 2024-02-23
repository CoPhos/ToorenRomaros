package com.ToorenRomaros.api.dto.streamSite;

import java.util.UUID;

public class GetStreamSiteFilmDto {
    private UUID id;
    private String url;
    private Boolean rent;
    private Boolean buy;
    private String filmName;
    private String streamSiteName;
    private UUID streamsiteId;

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

    public UUID getStreamsiteId() {
        return streamsiteId;
    }

    public void setStreamsiteId(UUID streamsiteId) {
        this.streamsiteId = streamsiteId;
    }
}
