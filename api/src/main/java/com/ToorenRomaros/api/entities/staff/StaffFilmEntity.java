package com.ToorenRomaros.api.entities.staff;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "staff_film")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class StaffFilmEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @NotNull(message = "Role can not be null")
    @Column(name = "ROLE", columnDefinition = "VARCHAR(50)")
    private String role;
    @Column(name = "AS", columnDefinition = "VARCHAR(50)")
    private String as;

    @ManyToOne
    @JoinColumn(name = "film_id")
    FilmEntity film;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    StaffEntity staff;

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
    public String getAs() {
        return as;
    }
    public void setAs(String as) {
        this.as = as;
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
