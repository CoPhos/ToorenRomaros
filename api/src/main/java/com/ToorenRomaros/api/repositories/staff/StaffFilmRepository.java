package com.ToorenRomaros.api.repositories.staff;

import com.ToorenRomaros.api.entities.staff.StaffFilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface StaffFilmRepository extends JpaRepository<StaffFilmEntity, UUID> {

    @Query(nativeQuery = true, value = "select * from film_staff f where f.film_id = ?1")
    List<StaffFilmEntity> findAllStaffByFilmId(String id );
}
