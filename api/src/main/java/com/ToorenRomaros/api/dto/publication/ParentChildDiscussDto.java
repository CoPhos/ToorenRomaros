package com.ToorenRomaros.api.dto.publication;

import com.ToorenRomaros.api.entities.publication.DiscussEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class ParentChildDiscussDto {
    private UUID id;
    @NotNull(message = "Parent discuss can not be null")
    private String parentId;
    @NotNull(message = "Child discuss can not be null")
    private String childId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }
}
