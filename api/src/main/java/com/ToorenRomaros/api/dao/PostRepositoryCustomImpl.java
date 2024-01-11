package com.ToorenRomaros.api.dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.*;
@Repository
public class PostRepositoryCustomImpl implements PostRepositoryCustom{
    private final EntityManager em;
    private static final Logger log = LoggerFactory.getLogger(PostRepositoryCustomImpl.class);

    public PostRepositoryCustomImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Map<String, Object> findPostsWithCustomAttributes(List<String> attributes, List<UUID> tags, boolean latest, boolean popular, int page, int size) {
        try{
            //todo: use projection
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return null;
    }
}
