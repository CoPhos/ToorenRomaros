package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;;import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
