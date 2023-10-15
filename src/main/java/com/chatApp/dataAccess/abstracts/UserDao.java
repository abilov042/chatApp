package com.chatApp.dataAccess.abstracts;

import com.chatApp.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User>  findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User findById(int id);

}
