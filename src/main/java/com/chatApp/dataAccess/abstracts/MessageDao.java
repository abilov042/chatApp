package com.chatApp.dataAccess.abstracts;

import com.chatApp.entities.concretes.Massage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MassageDao extends JpaRepository<Massage, Integer> {
}
