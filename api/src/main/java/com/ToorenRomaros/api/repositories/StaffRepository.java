package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<StaffEntity, UUID> {
}
