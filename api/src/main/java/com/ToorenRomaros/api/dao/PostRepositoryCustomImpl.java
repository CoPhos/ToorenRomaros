package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.publication.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.*;

@Repository
public class PostRepositoryCustomImpl implements PostRepositoryCustom {
    private final EntityManager em;
    private static final Logger log = LoggerFactory.getLogger(PostRepositoryCustomImpl.class);

    public PostRepositoryCustomImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Map<String, Object> findPostsMainInfoByLatestOrPopularOrTags(List<UUID> tags, boolean isReview, boolean latest, boolean popular, int page, int size) {
        try {
            StringBuilder queryText = new StringBuilder("SELECT DISTINCT new com.ToorenRomaros.api.entities.publication.PostEntity(p.id, p.tittle, p.publicationDateTime, p.likeCount, p.headline, p.tag) FROM PostEntity p ");
            StringBuilder queryCountText = new StringBuilder("SELECT COUNT(DISTINCT p.id) FROM post as p ");
            int argumentCounter = 1;
            List<UUID> providedParameters = new ArrayList<UUID>();

            if (tags != null && !tags.isEmpty()) {
                queryText.append("WHERE p.tag.id=?");
                queryText.append(argumentCounter);

                queryCountText.append("WHERE p.tag_id=?");
                queryCountText.append(argumentCounter);
                argumentCounter++;
                providedParameters.add(tags.get(0));
            }
            if (isReview) {
                queryText.append(" AND p.isReview=TRUE ");
                queryCountText.append(" AND p.is_review=TRUE ");
            }
            if(!(tags != null && !tags.isEmpty()) && !isReview){
                queryText.append(" WHERE p.status='PUBLISHED' ");
                queryCountText.append(" WHERE p.status='PUBLISHED' ");
            }else{
                queryText.append(" AND p.status='PUBLISHED' ");
                queryCountText.append(" AND p.status='PUBLISHED' ");
            }
            if (latest) {
                queryText.append("ORDER BY p.publicationDateTime DESC ");
                queryCountText.append("ORDER BY p.publication_datetime DESC ");
            }
            if (latest && popular) {
                queryText.append(", p.likeCount DESC");
                queryCountText.append(", p.like_count DESC");
            } else if (popular) {
                queryText.append("ORDER BY p.likeCount DESC");
                queryCountText.append("ORDER BY p.like_count DESC");
            }
            Query query = em.createQuery(queryText.toString());
            Query countQuery = em.createNativeQuery(queryCountText.toString());

            if (!providedParameters.isEmpty()) {
                argumentCounter = 1;
                for (UUID providedParameter : providedParameters) {
                    query.setParameter(argumentCounter, providedParameter);
                    countQuery.setParameter(argumentCounter, providedParameter.toString());
                    argumentCounter++;
                }
            }

            BigInteger bigInteger = (BigInteger) countQuery.getSingleResult();
            long totalRecords = bigInteger.longValue();

            query.setFirstResult(page * size);
            query.setMaxResults(size);

            List queryResultList = query.getResultList();

            Map<String, Object> result = new HashMap<>();
            result.put("queryResult", queryResultList);
            result.put("maxResults", totalRecords);
            result.put("totalPages", (int) Math.ceil((double) 2 / size));
            result.put("pageSize", size);
            result.put("pageNumber", page);
            return result;
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return null;
    }
}
