package com.ToorenRomaros.api.entities;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.media.PhotoEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "staff_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private List<FilmEntity> films;

    public void setFilms(List<FilmEntity> filmEntities) {
        this.films = filmEntities;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="staff")
    private List<PhotoEntity> photo;
    public List<PhotoEntity> getPhoto() { return photo;
    }
    public void setPohot(List<PhotoEntity> photoEntities) { this.photo = photoEntities;
    }
}
