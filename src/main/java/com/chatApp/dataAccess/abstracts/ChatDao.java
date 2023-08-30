package com.chatApp.dataAccess.abstracts;

import com.chatApp.entities.concretes.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatDao extends JpaRepository<Chat, Integer> {
}
