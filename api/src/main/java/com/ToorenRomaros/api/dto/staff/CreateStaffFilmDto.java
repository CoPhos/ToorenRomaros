package com.ToorenRomaros.api.dto.staff;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class CreateStaffFilmDto {
    @NotNull(message = "Rola can not be null")
    @Size(max = 50, message = "max size is 50 characters")
    private String role;
    @Size(max = 50, message = "max size is 50 characters")
    private String appearAs;
    @NotNull(message = "Film id can not be null")
    private String filmName;
    @NotNull(message = "Staff id can not be null")
    private String staffId;

    public String getStaffId() {
        return staffId;
    }
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getAppearAs() {
        return appearAs;
    }
    public void setAppearAs(String appearAs) {
        this.appearAs = appearAs;
    }
    public String getFilmName() {
        return filmName;
    }
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

}
