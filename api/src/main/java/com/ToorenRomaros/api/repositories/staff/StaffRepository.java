package com.ToorenRomaros.api.repositories.staff;

import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface StaffRepository extends JpaRepository<StaffEntity, UUID> {

}
