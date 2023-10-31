package com.ToorenRomaros.api.entities.media;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "image")
public class ImageEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "FILE_PATH")
    private String filePath;
    @Column(name = "SIZE")
    private String imageSize;

    @Any(metaColumn = @Column(name = "OWNER_TYPE"))
    @AnyMetaDef(idType = "string", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = FilmEntity.class, value = "F"),
                    @MetaValue(targetEntity = UserEntity.class, value = "U"),
                    @MetaValue(targetEntity = RichTextEntity.class, value = "RT"),
                    @MetaValue(targetEntity = VideoEntity.class, value = "V")
            })
    @JoinColumn(name="OWNER_ID")
    private Object owner;

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

}
