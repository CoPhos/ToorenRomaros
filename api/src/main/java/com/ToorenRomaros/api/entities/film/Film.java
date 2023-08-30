package com.ToorenRomaros.api.entities.film;

import com.ToorenRomaros.api.entities.Staff;
import com.ToorenRomaros.api.entities.StreamSite;
import com.ToorenRomaros.api.entities.genre.Genre;
import com.ToorenRomaros.api.entities.media.Photo;
import com.ToorenRomaros.api.entities.media.Video;
import com.ToorenRomaros.api.entities.publication.Publication;
import com.ToorenRomaros.api.entities.publication.Rating;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prequel", referencedColumnName = "tittle")
    private Film prequel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sequel", referencedColumnName = "tittle")
    private Film sequel;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "saga")
    private Saga saga;

    public void setSaga(Saga saga) { this.saga = saga;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="film")
    private List<Rating> ratings;
    public List<Rating> getRating() { return ratings;
    }
    public void setRating(List<Rating> ratings) { this.ratings = ratings;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="film")
    private List<Publication> publications;
    public List<Publication> getPublication() { return publications;
    }
    public void setPublication(List<Publication> publications) { this.publications = publications;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="film")
    private List<Photo> photos;
    public List<Photo> getPhoto() { return photos;
    }
    public void setPohto(List<Photo> photos) { this.photos = photos;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="film")
    private List<Video> videos;
    public List<Video> getVideos() { return videos;
    }
    public void setVideos(List<Video> videos) { this.videos = videos;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy="films")
    private List<Genre> genres;
    public List<Genre> getGenres() { return genres;
    }
    public void setGenres(List<Genre> genres) { this.genres = genres;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy="films")
    private List<Staff> staffs;
    public List<Staff> getStaffs() { return staffs;
    }
    public void setStaffs(List<Staff> staffs) { this.staffs = staffs;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy="films")
    private List<StreamSite> streamSites;
    public List<StreamSite> getStreamSites() { return streamSites;
    }
    public void setStreamSites(List<StreamSite> streamSites) { this.streamSites = streamSites;
    }
}
