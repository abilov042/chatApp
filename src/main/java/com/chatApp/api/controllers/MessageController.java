package com.chatApp.api.controllers;

import com.chatApp.business.abstractes.MessageService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.entities.concretes.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;



    @PostMapping("/getByRoomId")
    public DataResult<List<Message>> getMessageByRoomId(int id){

        return this.messageService.getMessageByRoomId(id);
    }
}
