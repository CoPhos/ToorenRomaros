package com.ToorenRomaros.api.entities.publication;

import com.ToorenRomaros.api.entities.user.UserEntity;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@AnyMetaDef(name = "OwnerMetaDef", idType = "uuid-char", metaType = "string",
        metaValues = {
                @MetaValue(targetEntity = PostEntity.class, value = "P"),
                @MetaValue(targetEntity = CommentEntity.class, value = "C"),
        })
@Entity
@Table(name = "thumbs_up", uniqueConstraints = @UniqueConstraint(columnNames = {"OWNER_ID", "USER_ID"}))
public class LikeEntity {
        @Id
        @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
        @Type(type="uuid-char")
        @GeneratedValue(generator = "uuid4")
        @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
        private UUID id;
        @Any(metaDef = "OwnerMetaDef", metaColumn = @Column(name = "OWNER_TYPE"))
        @NotNull(message = "Owner id can not be null")
        @JoinColumn(name = "OWNER_ID")
        private Object owner;
        @ManyToOne
        @NotNull(message = "User id can not be null")
        @JoinColumn(name = "USER_ID")
        UserEntity user;

        public UUID getId() {
                return id;
        }

        public void setId(UUID id) {
                this.id = id;
        }

        public Object getOwner() {
                return owner;
        }

        public void setOwner(Object owner) {
                this.owner = owner;
        }

        public UserEntity getUser() {
                return user;
        }

        public void setUser(UserEntity user) {
                this.user = user;
        }
}
