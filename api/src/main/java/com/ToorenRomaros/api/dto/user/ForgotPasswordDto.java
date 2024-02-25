package com.ToorenRomaros.api.dto.user;

import javax.validation.constraints.NotNull;

public class ForgotPasswordDto {
    @NotNull(message = "email can not be null")
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
