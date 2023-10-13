package com.ToorenRomaros.api.repositories.streamSite;

import com.ToorenRomaros.api.entities.streamSite.StreamSiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StreamSiteRepository extends JpaRepository<StreamSiteEntity, UUID> {
}
