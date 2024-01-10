package com.ToorenRomaros.api.dto.tag;

import com.ToorenRomaros.api.entities.publication.PostEntity;
import com.ToorenRomaros.api.entities.tag.TagEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

public class TagPostDto {
    private UUID id;
    String post;
    String tag;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}
