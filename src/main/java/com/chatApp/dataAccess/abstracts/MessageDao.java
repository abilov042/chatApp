package com.chatApp.dataAccess.abstracts;

import com.chatApp.entities.concretes.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message, Integer> {
}
