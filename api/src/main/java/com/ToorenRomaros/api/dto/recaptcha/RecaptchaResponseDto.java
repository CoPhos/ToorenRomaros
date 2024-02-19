package com.ToorenRomaros.api.dto.recaptcha;

import java.util.Date;

public class RecaptchaResponseDto {
    private Boolean success;
    private Date challenge_ts;
    private String hostname;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Date getChallenge_ts() {
        return challenge_ts;
    }

    public void setChallenge_ts(Date challenge_ts) {
        this.challenge_ts = challenge_ts;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
