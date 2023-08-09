package com.ToorenRomaros.api.entities.film;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@DiscriminatorValue("1")
public class Movie extends Film{

    private String boxOffice, runTime;
    private LocalDate theatersRelease;
    private Boolean atTheaters;

}
