
package com.ToorenRomaros.api.entities.media;

import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AnyMetaDef(name = "OwnerLikeMetaDef", idType = "uuid-char", metaType = "string",
        metaValues = {
                @MetaValue(targetEntity = Movie.class, value = "M"),
                @MetaValue(targetEntity = Serie.class, value = "S"),
                @MetaValue(targetEntity = UserEntity.class, value = "U"),
                @MetaValue(targetEntity = PostEntity.class, value = "RT"),
                @MetaValue(targetEntity = StaffEntity.class, value = "ST"),
                @MetaValue(targetEntity = StreamSiteEntity.class, value = "SS"),
        })
@Entity
@Table(name = "image")
public class ImageEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "FILE_PATH", columnDefinition = "VARCHAR(255)")
    @NotNull(message = "File path can not be null")
    private String filePath;
    @Column(name = "CREATED_AT", columnDefinition = "DATETIME")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "IMAGE_TYPE")
    @NotNull(message = "Image type can not be null")
    @Enumerated(EnumType.STRING)
    private ImageTypeEnum imageType;
    @Column(name = "IMAGE_SIZE")
    @NotNull(message = "Image size can not be null")
    @Enumerated(EnumType.STRING)
    private ImageSizeEnum imageSize;
    @Any(metaDef = "OwnerLikeMetaDef", metaColumn = @Column(name = "OWNER_TYPE"))
    @JoinColumn(name = "OWNER_ID")
    private Object owner;

    public ImageEntity(String filePath, LocalDateTime createdAt, ImageTypeEnum imageType, ImageSizeEnum imageSize, Object owner) {
        this.filePath = filePath;
        this.createdAt = createdAt;
        this.imageType = imageType;
        this.imageSize = imageSize;
        this.owner = owner;
    }

    public UUID getOwnerId() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (owner != null) {
            try {
                Method getIdMethod = owner.getClass().getMethod("getId");
                return (UUID) getIdMethod.invoke(owner);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            }
        }
        return null;
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

    public ImageTypeEnum getImageType() {
        return imageType;
    }

    public void setImageType(ImageTypeEnum imageType) {
        this.imageType = imageType;
    }

    public ImageSizeEnum getImageSize() {
        return imageSize;
    }

    public void setImageSize(ImageSizeEnum imageSize) {
        this.imageSize = imageSize;
    }
}
