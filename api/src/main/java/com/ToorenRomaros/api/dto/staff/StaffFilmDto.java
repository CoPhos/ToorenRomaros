package com.ToorenRomaros.api.dto.staff;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class StaffFilmDto {
    private UUID id;
    @NotNull(message = "Rola can not be null")
    private String role;
    private String appearAs;
    @NotNull(message = "Film id can not be null")
    private String filmName;
    @NotNull(message = "Staff id can not be null")
    private String staffName;
    private UUID staffId;

    public UUID getStaffId() {
        return staffId;
    }

    public void setStaffId(UUID staffId) {
        this.staffId = staffId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
