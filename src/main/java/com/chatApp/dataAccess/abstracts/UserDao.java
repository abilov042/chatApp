package com.chatApp.dataAccess.abstracts;

import com.chatApp.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    public Optional<User>  findByUsername(String username);
    public boolean existsByUsername(String username);
    public boolean existsByEmail(String email);

}
