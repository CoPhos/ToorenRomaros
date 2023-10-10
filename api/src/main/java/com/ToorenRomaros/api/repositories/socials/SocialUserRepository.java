package com.ToorenRomaros.api.repositories.socials;

import com.ToorenRomaros.api.entities.socials.SocialStaffEntity;
import com.ToorenRomaros.api.entities.socials.SocialUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SocialUserRepository extends JpaRepository<SocialUserEntity, UUID> {
    @Query(nativeQuery = true, value = "select * from social_user s where s.entity_id = ?1")
    List<SocialUserEntity> findSocialByUserId(String id);
}
