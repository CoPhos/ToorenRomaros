package com.ToorenRomaros.api.entities.staff;

import com.ToorenRomaros.api.entities.socials.SocialStaffUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "staff")
public class StaffEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(50)")
    @NotNull(message = "Firstname can not be null")
    private String firstName;
    @Column(name = "LAST_NAME", columnDefinition = "VARCHAR(50)")
    @NotNull(message = "Lastname can not be null")
    private String lastName;
    @Column(name = "FIRST_NAME", columnDefinition = "TEXT")
    @NotNull(message = "Biography can not be null")
    private String biography;
    @Column(name = "BIRTHDAY", columnDefinition = "DATE")
    @NotNull(message = "Birthday can not be null")
    @PastOrPresent(message = "Birthday can not be future")
    private LocalDate birthday;
    @Column(name = "BIRTH_PLACE", columnDefinition = "DATE")
    @NotNull(message = "Birthplace can not be null")
    private String birthplace;

    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    List<StaffFilmEntity> staffFilm;

    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    List<SocialStaffUserEntity> socialStaff;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
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
    public List<StaffFilmEntity> getStaffFilm() {
        return staffFilm;
    }
    public void setStaffFilm(List<StaffFilmEntity> staffFilm) {
        this.staffFilm = staffFilm;
    }
    public List<SocialStaffUserEntity> getSocialStaff() {
        return socialStaff;
    }
    public void setSocialStaff(List<SocialStaffUserEntity> socialStaff) {
        this.socialStaff = socialStaff;
    }
}
