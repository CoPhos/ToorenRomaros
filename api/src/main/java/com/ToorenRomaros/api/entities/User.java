package com.ToorenRomaros.api.entities;

import com.ToorenRomaros.api.entities.publication.Publication;
import com.ToorenRomaros.api.entities.publication.Rating;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class User {
    @Id
    private String username;
    private LocalDate birthday;
    private LocalDate createdDate;
    /*@Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;*/
    private String about;
    private Integer following, followme;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Rating> Ratings;
    public List<Rating> getRating() { return Ratings;
    }
    public void setRating(List<Rating> ratings) { this.Ratings = ratings;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Publication> Publications;
    public List<Publication> getPublication() { return Publications;
    }
    public void setPublication(List<Publication> publications) { this.Publications = publications;
    }
}
