package com.ToorenRomaros.api.entities.media;

import com.ToorenRomaros.api.entities.StaffEntity;
import com.ToorenRomaros.api.entities.film.FilmEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class PhotoEntity {
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
    private FilmEntity film;

    public void setFilm(FilmEntity filmEntity) { this.film = filmEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "staff")
    private StaffEntity staff;

    public void setStaff(StaffEntity staffEntity) { this.staff = staffEntity;
    }

}
