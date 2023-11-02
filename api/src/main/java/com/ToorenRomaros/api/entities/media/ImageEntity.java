
package com.ToorenRomaros.api.entities.media;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.entities.user.UserEntity;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
@AnyMetaDef(name = "OwnerMetaDef", idType = "uuid-char", metaType = "string",
        metaValues = {
                @MetaValue(targetEntity = Movie.class, value = "M"),
                @MetaValue(targetEntity = Serie.class, value = "S"),
                @MetaValue(targetEntity = UserEntity.class, value = "U"),
                @MetaValue(targetEntity = RichTextEntity.class, value = "RT"),
                @MetaValue(targetEntity = VideoEntity.class, value = "V")
        })
@Entity
@Table(name = "image")
public class ImageEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "FILE_PATH", columnDefinition = "VARCHAR(255)")
    private String filePath;
    @Column(name = "SIZE", columnDefinition = "VARCHAR(8)")
    private String imageSize;
    @Column(name = "CREATED_AT", columnDefinition = "DATETIME")
    private LocalDateTime createdAt;
    @Column(name = "IMAGE_TYPE", columnDefinition = "VARCHAR(24)")
    private String imageType;
    @Any(metaDef = "OwnerMetaDef", metaColumn = @Column(name = "OWNER_TYPE"))
    @JoinColumn(name="OWNER_ID")
    private Object owner;

    public ImageEntity(String filePath, String imageSize, LocalDateTime createdAt, String imageType, Object owner) {
        this.filePath = filePath;
        this.imageSize = imageSize;
        this.createdAt = createdAt;
        this.imageType = imageType;
        this.owner = owner;
    }

    public ImageEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    public Object getOwner() {
        return owner;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
