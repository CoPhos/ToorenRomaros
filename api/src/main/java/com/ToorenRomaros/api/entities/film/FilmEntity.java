package com.ToorenRomaros.api.entities.film;

import com.ToorenRomaros.api.entities.StaffEntity;
import com.ToorenRomaros.api.entities.StreamSiteEntity;
import com.ToorenRomaros.api.entities.genre.GenreEntity;
import com.ToorenRomaros.api.entities.media.PhotoEntity;
import com.ToorenRomaros.api.entities.media.VideoEntity;
import com.ToorenRomaros.api.entities.publication.PublicationEntity;
import com.ToorenRomaros.api.entities.publication.RatingEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="film_type",
        discriminatorType = DiscriminatorType.INTEGER)
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String tittle, synopsis, originalLanguage, distributor, suitableFor;
    private LocalDate streamingRelease;
    /*@Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prequel", referencedColumnName = "tittle")
    private FilmEntity prequel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sequel", referencedColumnName = "tittle")
    private FilmEntity sequel;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "saga")
    private SagaEntity saga;

    public void setSaga(SagaEntity sagaEntity) { this.saga = sagaEntity;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="film")
    private List<RatingEntity> ratings;
    public List<RatingEntity> getRating() { return ratings;
    }
    public void setRating(List<RatingEntity> ratings) { this.ratings = ratings;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="film")
    private List<PublicationEntity> publication;
    public List<PublicationEntity> getPublication() { return publication;
    }
    public void setPublication(List<PublicationEntity> publicationEntities) { this.publication = publicationEntities;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="film")
    private List<PhotoEntity> photo;
    public List<PhotoEntity> getPhoto() { return photo;
    }
    public void setPohto(List<PhotoEntity> photoEntities) { this.photo = photoEntities;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="film")
    private List<VideoEntity> video;
    public List<VideoEntity> getVideos() { return video;
    }
    public void setVideos(List<VideoEntity> videoEntities) { this.video = videoEntities;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy="films")
    private List<GenreEntity> genre;
    public List<GenreEntity> getGenres() { return genre;
    }
    public void setGenres(List<GenreEntity> genreEntities) { this.genre = genreEntities;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy="films")
    private List<StaffEntity> staff;
    public List<StaffEntity> getStaffs() { return staff;
    }
    public void setStaffs(List<StaffEntity> staffEntities) { this.staff = staffEntities;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy="films")
    private List<StreamSiteEntity> streamSite;
    public List<StreamSiteEntity> getStreamSites() { return streamSite;
    }
    public void setStreamSites(List<StreamSiteEntity> streamSiteEntities) { this.streamSite = streamSiteEntities;
    }
}

