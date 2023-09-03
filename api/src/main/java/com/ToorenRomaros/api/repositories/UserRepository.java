package com.ToorenRomaros.api.repositories;

import com.ToorenRomaros.api.entities.Comment;
import com.ToorenRomaros.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    List<User> findUserById(String username);

}
