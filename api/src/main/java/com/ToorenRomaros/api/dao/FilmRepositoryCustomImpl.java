package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.*;

@Repository
public class FilmRepositoryCustomImpl implements FilmRepositoryCustom {
    private static final Logger log = LoggerFactory.getLogger(FilmRepositoryCustomImpl.class);
    private final EntityManager em;

    public FilmRepositoryCustomImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Map<String, Object> findDinamicQuery(List<String> streamSites,
                                                List<String> genres,
                                                List<String> suitableFor,
                                                String filmType,
                                                String atTheaters,
                                                String atStreaming,
                                                String commingSoonStreaming,
                                                String commingSoonTheaters,
                                                String[] orderBy,
                                                String userRating,
                                                String superRating,
                                                String searchQuery,
                                                int page,
                                                int size) {
       try {
           StringBuilder queryText = new StringBuilder("SELECT DISTINCT film.* FROM film" +
                   " LEFT JOIN stream_film ON stream_film.film_id=film.id" +
                   " LEFT JOIN stream ON stream.id=stream_film.stream_id" +
                   " LEFT JOIN genre_film ON genre_film.film_id=film.id" +
                   " LEFT JOIN genre ON genre.id=genre_film.genre_id" +
                   " WHERE");
           int argumentCounter = 1;
           List<String> providedParameters = new ArrayList<String>();

           if (filmType != null && (filmType.equals("1") || filmType.equals("2"))) {
               queryText.append(" film.film_type = ?");
               queryText.append(argumentCounter);
               argumentCounter++;
               providedParameters.add(filmType);
           }else if (filmType != null){
               queryText.append(" film.film_type in (1,2)");
           }
           if (streamSites != null && !streamSites.isEmpty()) {
               queryText.append(" and stream.name in (?");
               queryText.append(argumentCounter);
               argumentCounter++;
               providedParameters.add(streamSites.get(0));
               for (int i = 1; i < streamSites.size(); i++) {
                   queryText.append(", ?");
                   queryText.append(argumentCounter);
                   argumentCounter++;
                   providedParameters.add(streamSites.get(i));
               }
               queryText.append(") ");
           }
           if (genres != null && !genres.isEmpty()) {
               queryText.append(" and genre.genre in (?");
               queryText.append(argumentCounter);
               argumentCounter++;
               providedParameters.add(genres.get(0));
               for (int i = 1; i < genres.size(); i++) {
                   queryText.append(", ?");
                   queryText.append(argumentCounter);
                   argumentCounter++;
                   providedParameters.add(genres.get(i));
               }
               queryText.append(") ");
           }
           if (suitableFor != null && !suitableFor.isEmpty()) {
               queryText.append(" and film.suitable_for in (?");
               queryText.append(argumentCounter);
               argumentCounter++;
               providedParameters.add(suitableFor.get(0));
               for (int i = 1; i < suitableFor.size(); i++) {
                   queryText.append(", ?");
                   queryText.append(argumentCounter);
                   argumentCounter++;
                   providedParameters.add(suitableFor.get(i));
               }
               queryText.append(") ");
           }
           if (atTheaters != null) {
               queryText.append(" and film.at_theaters = ?");
               queryText.append(argumentCounter);
               argumentCounter++;
               providedParameters.add(atTheaters);
           }
           if (commingSoonStreaming != null || commingSoonTheaters != null) {
               queryText.append(" and (film.STREAMING_RELEASE_DATE > CURDATE() OR film.THEATERS_RELEASE_DATE  > CURDATE())");
           }
           if (Objects.equals(atStreaming, "1")) {
               queryText.append(" and film.streaming_release_date is not null");
           }else if(Objects.equals(atStreaming, "0")){
               queryText.append(" and film.streaming_release_date is null");
           }
           if (Objects.equals(userRating, "down")) {
               queryText.append(" and film.average_user_rating < 60");
           } else if (Objects.equals(userRating, "up")) {
               queryText.append(" and film.average_user_rating > 60");
           }
           if (Objects.equals(superRating, "down")) {
               queryText.append(" and film.average_super_rating < 60");
           } else if (Objects.equals(superRating, "up")) {
               queryText.append(" and film.average_super_rating > 60");
           }
           if(searchQuery != null){
               queryText.append(" AND film.tittle LIKE '%");
               queryText.append(searchQuery);
               queryText.append("%' ");
           }

           String[] orderby = orderBy[0].split("-", 2);
           queryText.append(" ORDER BY film.");
           queryText.append(orderby[0]);
           queryText.append(" ");
           queryText.append(orderby[1].toUpperCase());
           for (int i = 1; i < orderBy.length; i++) {
              String[] arrOfString = orderBy[i].split("-", 2);
              queryText.append(", film.");
              queryText.append(arrOfString[0]);
               queryText.append(" ");
               queryText.append(arrOfString[1].toUpperCase());
          }
            log.info(queryText.toString());
           Query query = em.createNativeQuery(queryText.toString(), FilmEntity.class);

           StringBuilder queryCountText = new StringBuilder(queryText);
           queryCountText.delete(0, 22);
           queryCountText.insert(0, "SELECT COUNT(DISTINCT film.id)");
           log.info(queryCountText.toString());

           Query countQuery = em.createNativeQuery(queryCountText.toString());

           argumentCounter = 1;
           for (String providedParameter : providedParameters) {
               log.info(String.valueOf(argumentCounter));
               query.setParameter(argumentCounter, providedParameter);
               countQuery.setParameter(argumentCounter, providedParameter);
               argumentCounter++;
           }
           BigInteger bigInteger = (BigInteger) countQuery.getSingleResult();
           long totalRecords = bigInteger.longValue();

           query.setFirstResult(page * size);
           query.setMaxResults(size);
           log.info(query.unwrap(org.hibernate.query.NativeQuery.class).getQueryString());

           List<FilmEntity> queryResultList = query.getResultList();

           Map<String, Object> result = new HashMap<>();
           result.put("queryResult", queryResultList);
           result.put("maxResults", totalRecords);
           result.put("totalPages", (int) Math.ceil((double) totalRecords / size));
           result.put("pageSize", size);
           result.put("pageNumber", page);
           return result;
       }catch (Exception e){
           log.info(e.getMessage());
       }
        return null;
    }
}
