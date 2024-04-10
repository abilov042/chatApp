package com.chatApp.api.controllers;

import com.chatApp.business.abstractes.MessageService;
import com.chatApp.entities.concretes.Message;
import com.chatApp.entities.concretes.TestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ChatMessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageService messageService;

    @MessageMapping("/api/chat")
    @SendTo("/topic/message")
    public Message receiveMessage(@Payload Message message){
        System.out.println(message);
        message.setCreatedAt(LocalDateTime.now());
        this.messageService.add(message);
        // simpMessagingTemplate.convertAndSend("/topic/message", message);
        return message;
    }

//    @MessageMapping("/app/send/{roomName}")
//    @SendTo("/room/{roomName}")
//    public TestMessage sendMessage(@Payload TestMessage message, @DestinationVariable String roomName) {
//
//        return new TestMessage(message.getReceiverName(), message.getMessage());
//    }

}
