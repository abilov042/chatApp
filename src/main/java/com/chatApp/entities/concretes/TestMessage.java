package com.chatApp.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestMessage {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;

    public TestMessage(String receiverName, String message){
        this.receiverName = receiverName;
        this.message = message;
    }

}
