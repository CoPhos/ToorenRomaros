package com.ToorenRomaros.api.entities.streamSite;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "stream")
public class StreamSiteEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "NAME", columnDefinition = "VARCHAR(50)")
    @Size(max = 50, message = "max size is 50 characters")
    @NotNull(message = "Stream site name can not be null")
    private String name;
    @Column(name = "PRICE", columnDefinition = "VARCHAR(8)")
    @NotNull(message = "Price can not be null")
    @Size(max = 8, message = "max size is 8 characters")
    private String price;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
