package com.ToorenRomaros.api.entities.film;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("2")
public class Serie extends Film{

}
