package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
