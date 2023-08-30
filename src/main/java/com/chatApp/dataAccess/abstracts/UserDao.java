package com.chatApp.dataAccess.abstracts;

import com.chatApp.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

}
