package com.ToorenRomaros.api.entities.publication;

import javax.persistence.Entity;

@Entity
public class Post extends PublicationEntity {
    private String tittle, body;
    private Integer discussCount;
    private Integer rating;

}
