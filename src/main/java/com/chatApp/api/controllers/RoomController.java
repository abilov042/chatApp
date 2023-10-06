package com.chatApp.api.controllers;

import com.chatApp.business.abstractes.RoomService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.entities.concretes.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/save")
    public Result save(@RequestBody Room room){

        return this.roomService.save(room);
    }

    @PostMapping("/check")
    public DataResult<Room> getRoomByRoomName(String roomName){

        return this.roomService.getRoomByRoomName(roomName);
    }

}
