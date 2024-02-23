package com.ToorenRomaros.api.dto.staff;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

public class CreateStaffDto {
    @NotNull(message = "Firstname can not be null")
    @Size(max = 50, message = "max size is 50 characters")
    private String firstName;
    @NotNull(message = "Lastname can not be null")
    @Size(max = 50, message = "max size is 50 characters")
    private String lastName;
    @NotNull(message = "Biography can not be null")
    private String biography;
    @NotNull(message = "Birthday can not be null")
    @PastOrPresent(message = "Birthday can not be future")
    private LocalDate birthday;
    @Size(max = 50, message = "max size is 50 characters")
    @NotNull(message = "Birthplace can not be null")
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

