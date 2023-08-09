package com.ToorenRomaros.api.entities.film;

import com.ToorenRomaros.api.entities.Rating;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="film_type",
        discriminatorType = DiscriminatorType.INTEGER)
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String tittle, synopsis, originalLanguage, distributor, suitableFor;
    private LocalDate streamingRelease;
    /*@Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;*/

    @OneToMany(cascade = CascadeType.ALL, mappedBy="film")
    private List<Rating> Ratings;
    public List<Rating> getRating() { return Ratings;
    }
    public void setRating(List<Rating> ratings) { this.Ratings = Ratings;
    }
}
