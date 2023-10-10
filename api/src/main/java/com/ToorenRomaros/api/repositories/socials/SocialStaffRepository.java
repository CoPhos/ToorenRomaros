package com.ToorenRomaros.api.repositories.socials;

import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.entities.socials.SocialStaffEntity;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SocialStaffRepository extends JpaRepository<SocialStaffEntity, UUID> {
    @Query(nativeQuery = true, value = "select * from social_staff s where s.entity_id = ?1")
    List<SocialStaffEntity> findSocialByStaffId(String id);
}
