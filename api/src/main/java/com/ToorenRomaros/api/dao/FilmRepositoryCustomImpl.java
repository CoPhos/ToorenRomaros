package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.film.Movie;
import com.ToorenRomaros.api.entities.film.Serie;
import com.ToorenRomaros.api.services.FilmServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FilmRepositoryCustomImpl implements FilmRepositoryCustom {
    private final EntityManager em;
    public FilmRepositoryCustomImpl(EntityManager em) {
        this.em = em;
    }
    private static final Logger log = LoggerFactory.getLogger(FilmRepositoryCustomImpl.class);
    @Override
    public List<FilmEntity> findFilmByNameAndDuration(String name, String duration) {
        try{
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<FilmEntity> criteriaQuery = criteriaBuilder.createQuery(FilmEntity.class);

            Root<FilmEntity> root = criteriaQuery.from(FilmEntity.class);
            Root<Movie> movieRoot = criteriaBuilder.treat(root, Movie.class);
            Root<Serie> serieRoot = criteriaBuilder.treat(root, Serie.class);
            List<Predicate> predicates = new ArrayList<>();

            if(name != null){
                predicates.add(criteriaBuilder.equal(root.get("tittle"), name));
            }
            if(duration != null){
                predicates.add(criteriaBuilder.equal(movieRoot.get("runTime"), duration));
            }
            criteriaQuery.where(predicates.toArray(new Predicate[0]));

            TypedQuery<FilmEntity> query = em.createQuery(criteriaQuery);
            return query.getResultList();
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }
}
