package com.ToorenRomaros.api.repositories.socials;

import com.ToorenRomaros.api.entities.socials.SocialUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SocialUserRepository extends JpaRepository<SocialUserEntity, UUID> {
}
