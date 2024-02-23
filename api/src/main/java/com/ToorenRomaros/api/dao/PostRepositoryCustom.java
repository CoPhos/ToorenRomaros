package com.ToorenRomaros.api.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PostRepositoryCustom {
    Map<String, Object> findPostsMainInfoByLatestOrPopularOrTags(List<UUID> tags, boolean isReview, boolean latest, boolean popular,String searchQuery, int page, int size) throws SQLException;
}
