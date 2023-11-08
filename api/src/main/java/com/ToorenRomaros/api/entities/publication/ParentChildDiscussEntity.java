package com.ToorenRomaros.api.entities.publication;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "parent_child_discuss")
public class ParentChildDiscussEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "parent_discuss_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DiscussEntity parent;

    @ManyToOne
    @JoinColumn(name = "child_discuss_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DiscussEntity child;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DiscussEntity getParent() {
        return parent;
    }

    public void setParent(DiscussEntity parent) {
        this.parent = parent;
    }

    public DiscussEntity getChild() {
        return child;
    }

    public void setChild(DiscussEntity child) {
        this.child = child;
    }
}
