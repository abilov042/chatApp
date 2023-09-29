package com.chatApp.entities.concretes;

import lombok.Data;

@Data
public class TestMessage {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;
}
