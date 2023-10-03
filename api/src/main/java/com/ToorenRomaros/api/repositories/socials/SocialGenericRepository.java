package com.ToorenRomaros.api.repositories.socials;

import com.ToorenRomaros.api.entities.socials.SocialGenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SocialGenericRepository extends JpaRepository<SocialGenericEntity, UUID> {
}
