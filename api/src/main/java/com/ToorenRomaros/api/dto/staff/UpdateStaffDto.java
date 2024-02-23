package com.ToorenRomaros.api.dto.staff;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UpdateStaffDto {
    @Size(max = 50, message = "max size is 50 characters")
    private String firstName;
    @Size(max = 50, message = "max size is 50 characters")
    private String lastName;
    private String biography;
    @PastOrPresent(message = "Birthday can not be future")
    private LocalDate birthday;
    @Size(max = 50, message = "max size is 50 characters")
    private String birthplace;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
}
