package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.publication.PublicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublicationRepository extends JpaRepository<PublicationEntity, UUID> {
}
