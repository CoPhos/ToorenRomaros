package com.ToorenRomaros.api.entities;

import com.ToorenRomaros.api.entities.film.Film;
import com.ToorenRomaros.api.entities.media.Photo;
import com.ToorenRomaros.api.entities.media.Video;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Staff {
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
    private List<Film> films;

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="staff")
    private List<Photo> photos;
    public List<Photo> getPhoto() { return photos;
    }
    public void setPohot(List<Photo> photos) { this.photos = photos;
    }
}
