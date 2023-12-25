package com.ToorenRomaros.api.repositories.user;

import com.ToorenRomaros.api.entities.user.UserTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserTokenRepository extends JpaRepository<UserTokenEntity, UUID> {
    Optional<UserTokenEntity> findByRefreshToken(String refreshToken);
    Optional<UserTokenEntity> deleteByUserId(UUID userId);

}
