package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserFollowerService {
    public Page<UserFollowerDto> getAllFollowsByUserIds(UUID id, Pageable pageRequest, String type);
    public UserFollowerDto addFollow(UUID idUser, UUID toFollow, String username);
    public void deleteFollowByIds(UUID idUser, UUID toFollow, String username);
}
