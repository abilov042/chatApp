package com.chatApp.business.abstractes;

import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.entities.concretes.Room;

public interface RoomService {
    Result save(Room room);
    DataResult<Room> getRoomByRoomName(String roomName);
}
