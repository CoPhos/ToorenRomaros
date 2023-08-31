package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.StreamSite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StreamSiteRepository extends JpaRepository<StreamSite, UUID> {
}
