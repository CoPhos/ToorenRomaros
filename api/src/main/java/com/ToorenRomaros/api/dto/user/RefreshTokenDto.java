package com.ToorenRomaros.api.dto.user;

import java.util.UUID;

public class RefreshTokenDto {
    private UUID id;
    private String refreshToken;
    private String user;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getRefreshToken() {
        return refreshToken;
    }
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
}
