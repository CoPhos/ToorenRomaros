package com.ToorenRomaros.api.entities.media;

import com.ToorenRomaros.api.entities.Staff;
import com.ToorenRomaros.api.entities.film.Film;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String photo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "film")
    private Film film;

    public void setFilm(Film film) { this.film = film;
    }

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "staff")
    private Staff staff;

    public void setStaff(Staff staff) { this.staff = staff;
    }

}
