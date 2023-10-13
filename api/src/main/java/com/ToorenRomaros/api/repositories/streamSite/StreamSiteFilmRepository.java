package com.ToorenRomaros.api.repositories.streamSite;

import com.ToorenRomaros.api.entities.staff.StaffFilmEntity;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteFilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface StreamSiteFilmRepository extends JpaRepository<StreamSiteFilmEntity, UUID> {
    @Query(nativeQuery = true, value = "select * from stream_film f where f.film_id = ?1")
    List<StreamSiteFilmEntity> findAllStreamSitesByFilmId(String id );
}
