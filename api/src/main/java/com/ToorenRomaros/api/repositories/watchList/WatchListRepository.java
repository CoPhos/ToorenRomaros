package com.ToorenRomaros.api.repositories.watchList;

import com.ToorenRomaros.api.entities.watchList.WatchListEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface WatchListRepository extends JpaRepository<WatchListEntity, UUID> {
    @Query(nativeQuery = true, value = "SELECT DISTINCT wl.* from watch_list as wl " +
            "inner join film as f on wl.film_id=f.id " +
            "where wl.user_id=?1 " +
            "ORDER BY ?#{#pageable}",
            countQuery = "select count(distinct wl.id) from watch_list as wl")
    List<WatchListEntity> findWatchListByUserAndFilmType(String id, String filmType, Pageable pageable);
}
