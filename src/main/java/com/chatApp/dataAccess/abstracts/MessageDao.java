package com.chatApp.dataAccess.abstracts;

import com.chatApp.entities.concretes.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageDao extends JpaRepository<Message, Integer> {

    List<Message> getMessageByRoom_Id(int id);
}
