package com.ToorenRomaros.api.entities.publication;

import org.hibernate.annotations.GenericGenerator;
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
    @JoinColumn(name = "parent_discuss")
    private DiscussEntity parent;

    @ManyToOne
    @JoinColumn(name = "child_discuss")
    private DiscussEntity child;
}
