package com.ToorenRomaros.api.entities.film;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("1")
public class Movie extends FilmEntity {

    private String boxOffice, runTime;
    private LocalDate theatersRelease;
    private Boolean atTheaters;

}
