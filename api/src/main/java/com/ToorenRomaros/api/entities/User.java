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
    private Integer followingCount, followmeCount;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "following")
    private List<User> followers;
    @JoinTable(name = "followers",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "follower_id")})
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> following;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Publication> publications;
    public List<Publication> getPublication() { return publications;
    }
    public void setPublication(List<Publication> publications) { this.publications = publications;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Rating> ratings;
    public List<Rating> getRatings() { return ratings;
    }
    public void setRatings(List<Rating> ratings) { this.ratings = ratings;
    }
}
