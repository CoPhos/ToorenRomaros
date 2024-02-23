package com.ToorenRomaros.api.entities.staff;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "film_staff")
public class StaffFilmEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @NotNull(message = "Role can not be null")
    @Column(name = "ROLE", columnDefinition = "VARCHAR(50)")
    @Size(max = 50, message = "max size is 50 characters")
    private String role;
    @Column(name = "APPEAR_AS", columnDefinition = "VARCHAR(50)")
    @Size(max = 50, message = "max size is 50 characters")
    private String appearAs;
    @ManyToOne
    @JoinColumn(name = "film_id")
    FilmEntity film;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    StaffEntity staff;

    public StaffFilmEntity(String role, String appearAs, FilmEntity film, StaffEntity staff) {
        this.role = role;
        this.appearAs = appearAs;
        this.film = film;
        this.staff = staff;
    }

    public StaffFilmEntity() {
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
    public String getappearAs() {
        return appearAs;
    }
    public void setappearAs(String as) {
        this.appearAs = as;
    }
    public FilmEntity getFilm() {
        return film;
    }
    public void setFilm(FilmEntity film) {
        this.film = film;
    }
    public StaffEntity getStaff() {
        return staff;
    }
    public void setStaff(StaffEntity staff) {
        this.staff = staff;
    }
}
