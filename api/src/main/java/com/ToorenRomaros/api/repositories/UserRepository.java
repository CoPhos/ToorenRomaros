package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
