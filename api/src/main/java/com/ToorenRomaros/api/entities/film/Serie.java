package com.ToorenRomaros.api.entities.film;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")

public class Serie extends FilmEntity {
}
