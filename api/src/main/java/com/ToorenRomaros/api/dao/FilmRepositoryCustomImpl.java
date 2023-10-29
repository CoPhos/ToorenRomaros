package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    public List<FilmEntity> findFilmByNameAndDuration(String streamSiteId, List<UUID> genres, String suitableFor, String filmType, boolean atTheaters, boolean commingSoon, boolean atStreaming) {
        try {
            StringBuilder queryText = new StringBuilder("SELECT film.* FROM film" +
                    " INNER JOIN stream_film ON stream_film.film_id=film.id" +
                    " INNER JOIN genre_film ON genre_film.film_id=film.id" +
                    " WHERE");
            int argumentCounter = 1;
            List<String> providedParameters = new ArrayList<String>();
            if(filmType != null){
                queryText.append(" film.film_type = ?");
                queryText.append(filmType);
                argumentCounter++;
                providedParameters.add(filmType);
            }
            if(streamSiteId != null || !streamSiteId.isBlank()){
                queryText.append(" and stream_film.stream_id = ?");
                queryText.append(argumentCounter);
                argumentCounter++;
                providedParameters.add(streamSiteId);
            }
            if(genres != null || genres.isEmpty()){
                queryText.append(" and genre_film.genre_id in (?");
                queryText.append(argumentCounter);
                argumentCounter++;
                providedParameters.add(genres.get(0).toString());
                for (int i = 1; i < genres.size(); i++) {
                    queryText.append(", ?");
                    queryText.append(argumentCounter);
                    argumentCounter++;
                    providedParameters.add(genres.get(i).toString());
                }
                queryText.append(") ");
            }
            if(suitableFor != null){
                queryText.append(" and film.suitable_for = ?");
                queryText.append(argumentCounter);
                argumentCounter++;
                providedParameters.add(suitableFor);
            }
            if(atTheaters){
                queryText.append(" and film.at_theaters = ?");
                queryText.append(argumentCounter);
                argumentCounter++;
                providedParameters.add("true");
            }
            if(commingSoon){
                queryText.append(" and film.cooming_soon = ?");
                queryText.append(argumentCounter);
                providedParameters.add("true");
            }if(commingSoon){
                queryText.append(" and film.streaming_release_date = is not null");
            }

            queryText.append(" GROUP BY film.id");
            Query query = em.createNativeQuery(queryText.toString(), FilmEntity.class);
            argumentCounter = 1;
            for (String providedParameter : providedParameters) {
                log.info(String.valueOf(argumentCounter));
                query.setParameter(argumentCounter, providedParameter);
                argumentCounter++;
            }

            return (List<FilmEntity>) query.getResultList();
        }catch (Exception e){
            log.info(e.getMessage());
            log.info(e.getCause().toString());
            return null;
        }
    }
}
