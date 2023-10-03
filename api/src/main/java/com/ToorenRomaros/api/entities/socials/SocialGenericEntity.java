package com.ToorenRomaros.api.entities.socials;

import com.ToorenRomaros.api.entities.staff.StaffEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;
@Entity
@Table(name = "social_staff")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class SocialGenericEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "URL", columnDefinition = "VARCHAR(255)")
    @NotNull(message = "Url can not be null")
    private String url;

    @ManyToOne
    @JoinColumn(name = "entity_id")
    StaffEntity staff;

    @ManyToOne
    @JoinColumn(name = "social_id")
    SocialEntity social;


    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public StaffEntity getStaff() {
        return staff;
    }
    public void setStaff(StaffEntity staff) {
        this.staff = staff;
    }
    public SocialEntity getSocial() {
        return social;
    }
    public void setSocial(SocialEntity social) {
        this.social = social;
    }
}
