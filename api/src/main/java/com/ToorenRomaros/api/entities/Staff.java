package com.ToorenRomaros.api.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;


}
