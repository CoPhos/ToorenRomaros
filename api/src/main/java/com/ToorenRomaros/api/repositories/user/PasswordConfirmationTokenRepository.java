package com.ToorenRomaros.api.repositories.user;

import com.ToorenRomaros.api.entities.user.PasswordConfirmationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PasswordConfirmationTokenRepository extends JpaRepository<PasswordConfirmationTokenEntity, UUID> {
    Optional<PasswordConfirmationTokenEntity> findByToken(String token);
}
