package com.chatApp.dataAccess.abstracts;

import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.entities.concretes.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomDao extends JpaRepository<Room, Integer> {
    Optional<Room> getRoomByRoomName(String roomName);
}
