package com.ToorenRomaros.api.repositories.staff;

import com.ToorenRomaros.api.entities.staff.StaffFilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffFilmRepository extends JpaRepository<StaffFilmEntity, UUID> {
}
