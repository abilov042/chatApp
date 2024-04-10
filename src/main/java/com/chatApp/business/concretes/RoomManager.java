package com.chatApp.business.concretes;

import com.chatApp.business.abstractes.RoomService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.core.untilitues.result.SuccessDataResult;
import com.chatApp.core.untilitues.result.SuccessResult;
import com.chatApp.dataAccess.abstracts.RoomDao;
import com.chatApp.entities.concretes.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomManager implements RoomService {

    private final RoomDao roomDao;

    @Override
    public Result save(Room room) {
        this.roomDao.save(room);
        return new SuccessResult("saved room");
    }

    @Override
    public DataResult<Room> getRoomByRoomName(String roomName) {
        boolean existRoom = roomDao.existsRoomByRoomName(roomName);

        if(!existRoom) {
            Room room = new Room();
            room.setRoomName(roomName);
            this.roomDao.save(room);
        }
        return new SuccessDataResult<>(this.roomDao.getRoomByRoomName(roomName).orElseThrow(),"room is found");
    }
}
