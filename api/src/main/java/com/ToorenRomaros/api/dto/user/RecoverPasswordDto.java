package com.ToorenRomaros.api.dto.user;

import javax.validation.constraints.NotNull;

public class RecoverPasswordDto {
    @NotNull(message = "new password can not be null")
    private String newPassword;
    @NotNull(message = "Verification token can not be null")
    private String token;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
