package com.chatApp.dataAccess.abstracts;

import com.chatApp.entities.concretes.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, Integer> {

}
