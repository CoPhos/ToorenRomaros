package com.ToorenRomaros.api.dto.user;

public class UserSignedInDto {
    private String refreshToken;
    private String accessToken;
    private String username;
    private String userId;

    public UserSignedInDto(String username, String accessToken, String userId) {
        this.accessToken = accessToken;
        this.username = username;
        this.userId = userId;
    }

    public UserSignedInDto() {
    }

    public String getRefreshToken() {
        return refreshToken;
    }
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
