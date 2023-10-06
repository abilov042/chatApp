package com.chatApp.api.controllers;

import com.chatApp.business.abstractes.MessageService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.entities.concretes.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/add")
    public Result add(@RequestBody Message message){

        return this.messageService.add(message);
    }

    @PostMapping("/getByRoomId")
    public DataResult<List<Message>> getMessageByRoomId(@RequestParam int id){

        return this.messageService.getMessageByRoomId(id);
    }
}
