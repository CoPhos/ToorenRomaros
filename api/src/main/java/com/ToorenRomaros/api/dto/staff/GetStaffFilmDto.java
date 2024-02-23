package com.ToorenRomaros.api.dto.staff;

public class GetStaffFilmDto {
    private String id;
    private String role;
    private String appearAs;
    private String filmName;
    private String staffName;
    private String staffId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
