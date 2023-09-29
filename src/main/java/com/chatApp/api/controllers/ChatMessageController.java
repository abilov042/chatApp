package com.chatApp.api.controllers;

import com.chatApp.entities.concretes.Message;
import com.chatApp.entities.concretes.TestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ChatMessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    @SendTo("/topic/message")
    public TestMessage receiveMessage(@Payload TestMessage message){
        System.out.println(message);
        // simpMessagingTemplate.convertAndSend("/topic/message", message);
        return message;
    }

    @MessageMapping("/private-message")
    public TestMessage recMessage(@Payload TestMessage message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        System.out.println(message.toString());
        return message;
    }

}
