package com.chatApp.api.controllers;

import com.chatApp.business.abstractes.MailSenderService;
import com.chatApp.entities.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/chatapp/mail")
public class MailSenderController {

    private final MailSenderService mailSenderService;


    @PostMapping("/sendMessage")
    public boolean sendMessage(@RequestBody User user){

        mailSenderService.sendMessage(user);

        return true;
    }
}
