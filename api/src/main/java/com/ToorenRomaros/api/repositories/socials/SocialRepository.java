package com.ToorenRomaros.api.repositories.socials;


import com.ToorenRomaros.api.entities.socials.SocialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SocialRepository extends JpaRepository<SocialEntity, UUID> {
}
