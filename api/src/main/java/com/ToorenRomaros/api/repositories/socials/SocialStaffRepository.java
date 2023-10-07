package com.ToorenRomaros.api.repositories.socials;

import com.ToorenRomaros.api.entities.socials.SocialStaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SocialStaffRepository extends JpaRepository<SocialStaffEntity, UUID> {
}
