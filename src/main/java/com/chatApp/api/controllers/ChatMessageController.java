package com.chatApp.api.controllers;

import com.chatApp.entities.concretes.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ChatMessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/message")
    public void ChatEndPoint(@Payload Message message){

    }

}
