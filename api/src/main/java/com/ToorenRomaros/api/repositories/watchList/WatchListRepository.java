package com.ToorenRomaros.api.repositories.watchList;

import com.ToorenRomaros.api.entities.watchList.WatchListEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WatchListRepository extends JpaRepository<WatchListEntity, UUID> {
    @Query(value = "SELECT DISTINCT wl from WatchListEntity wl " +
            "left join FilmEntity f on wl.film.id=f.id " +
            "where wl.user.id=?1 ")
    Page<WatchListEntity> findWatchListByUserAndFilmType(UUID id, Pageable pageable);

    @Query(nativeQuery = true, value = "select wl.* from watch_list as wl where wl.user_id=?1 and wl.film_id=?2")
    Optional<WatchListEntity> findByUserAndFilm(String user, String film);
}
