package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff, UUID> {
}
