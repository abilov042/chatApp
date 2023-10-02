package com.chatApp.dataAccess.abstracts;

import com.chatApp.entities.concretes.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageDao extends JpaRepository<Message, Integer> {
     @Query("SELECT m FROM Message m JOIN m.sender.rooms r WHERE r.roomName = :roomName")
     List<Message> findMessagesByRoomName(String roomName);
}
