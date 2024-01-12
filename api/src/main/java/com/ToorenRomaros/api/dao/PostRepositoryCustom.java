package com.ToorenRomaros.api.dao;

import com.ToorenRomaros.api.entities.publication.PostEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PostRepositoryCustom {
    Map<String, Object> findPostsMainInfoByLatestOrPopularOrTags(List<UUID> tags, boolean isReview, boolean latest, boolean popular, int page, int size);
}
