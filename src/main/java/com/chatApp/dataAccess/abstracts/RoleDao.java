package com.chatApp.dataAccess.abstracts;

import com.chatApp.entities.concretes.ERole;
import com.chatApp.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, Integer> {

    public Optional<Role> findByName(ERole role);
}
