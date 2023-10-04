package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.dto.user.UserFollowingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserFollowerService {
    public Page<?> getAllFollowsByUserIds(UUID id, Pageable pageRequest, String type);
    public UserFollowerDto addFollow(UUID idUser, UUID toFollow,String type, String username);
    public void deleteFollowByIds(UUID idUser, UUID toFollow, String type, String username);
}
