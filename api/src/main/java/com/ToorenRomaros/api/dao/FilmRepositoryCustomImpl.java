package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.FilmEntity_;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.entities.genre.GenreFilmEntity;
import com.ToorenRomaros.api.entities.genre.GenreFilmEntity_;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteFilmEntity;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteFilmEntity_;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FilmRepositoryCustomImpl implements FilmRepositoryCustom {
    private final EntityManager em;
    public FilmRepositoryCustomImpl(EntityManager em) {
        this.em = em;
    }
    private static final Logger log = LoggerFactory.getLogger(FilmRepositoryCustomImpl.class);
    @Override
    public List<StreamSiteFilmEntity> findFilmByNameAndDuration(String streamSiteId, List<UUID> genres, String suitableFor, String filmType, boolean atTheaters, boolean commingSoon, boolean atStreaming) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<StreamSiteFilmEntity> cq = cb.createQuery(StreamSiteFilmEntity.class);

            Root<StreamSiteFilmEntity> streamSiteFilmEntityRoot = cq.from(StreamSiteFilmEntity.class);
            Root<GenreFilmEntity> genreFilmEntityRoot = cq.from(GenreFilmEntity.class);

            Root<FilmEntity> filmEntityRoot = cq.from(FilmEntity.class);
//            Join a = filmEntityRoot.join(StreamSiteFilmEntity_.film);

            Join<StreamSiteFilmEntity, FilmEntity> stream_film_join = streamSiteFilmEntityRoot.join(StreamSiteFilmEntity_.film);
            Join<GenreFilmEntity, FilmEntity> genre_film_join = genreFilmEntityRoot.join(GenreFilmEntity_.film);
            cq.select(streamSiteFilmEntityRoot).distinct(true);
            List<Predicate> predicates = new ArrayList<>();

            if(streamSiteId != null){
                Predicate predicateForStreamSite = cb.equal(streamSiteFilmEntityRoot.get(StreamSiteFilmEntity_.streamSite).get("id"), UUID.fromString(streamSiteId));
                predicates.add(predicateForStreamSite);
            }
            if(genres != null){
                Predicate predicateForGenres = genreFilmEntityRoot.get(GenreFilmEntity_.genre).get("id").in(genres);
                predicates.add(predicateForGenres);
            }
//            if(suitableFor != null){
//                Predicate predicateForSuitableFor = cb.equal(filmRoot.get("suitableFor"), suitableFor);
//                predicates.add(predicateForSuitableFor);
//            }
//            if(filmType != null){
//                Predicate predicateForFilmType = cb.equal(filmRoot.get("film_type"), filmType);
//                finalPredicae = cb.and(predicateForFilmType);
//            }
//            if(atTheaters){
//                Predicate predicateForAtTheaters = cb.equal(movieRoot.get("atTheaters"), true);
//                predicates.add(predicateForAtTheaters);
//            }
//            if(commingSoon){
//                Predicate predicateForCoomingSoon = filmRoot.get("coomingSoon").isNotNull();
//                predicates.add(predicateForCoomingSoon);
//            }
//            if(atStreaming){
//                Predicate predicateForAtStreaming = filmRoot.get("streamingReleaseDate").isNotNull();
//                predicates.add(predicateForAtStreaming);
//            }
//            cq.multiselect(
//                    stream_film_join.get(FilmEntity_.tittle),
//                    stream_film_join.get(FilmEntity_.averageSuperRating),
//                    stream_film_join.get(FilmEntity_.averageUserRating)
//            ).distinct(true);

            cq.where(predicates.toArray(new Predicate[0]));

            org.hibernate.query.Query hibernateQuery = em.createQuery(cq).unwrap(org.hibernate.query.Query.class);
            String sql = hibernateQuery.getQueryString();
            log.info(sql);

            TypedQuery<StreamSiteFilmEntity> query = em.createQuery(cq);

            return query.getResultList();

    }
}
