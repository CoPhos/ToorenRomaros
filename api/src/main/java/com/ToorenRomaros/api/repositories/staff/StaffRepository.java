package com.ToorenRomaros.api.repositories.staff;

import com.ToorenRomaros.api.entities.staff.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<StaffEntity, UUID> {
}
