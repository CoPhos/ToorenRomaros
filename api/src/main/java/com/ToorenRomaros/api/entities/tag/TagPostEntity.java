package com.ToorenRomaros.api.entities.tag;

import com.ToorenRomaros.api.entities.publication.PostEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tag_post")
public class TagPostEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    PostEntity post;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    TagEntity tag;

    public TagPostEntity() {
    }

    public TagPostEntity(PostEntity post, TagEntity tag) {
        this.post = post;
        this.tag = tag;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public PostEntity getPost() {
        return post;
    }
    public void setPost(PostEntity post) {
        this.post = post;
    }
    public TagEntity getTag() {
        return tag;
    }
    public void setTag(TagEntity tag) {
        this.tag = tag;
    }
}
