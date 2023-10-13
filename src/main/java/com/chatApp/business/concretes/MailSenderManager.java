package com.chatApp.business.concretes;

import com.chatApp.business.abstractes.MailSenderService;
import com.chatApp.entities.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderManager implements MailSenderService {

    private final JavaMailSender javaMailSender;

    @Override
    public boolean sendMessage(User user) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("randomislerucun123@gmail.com");
        //user.getEmail() for send dynamic mail
        simpleMailMessage.setTo("shamilabilov599@gmail.com");
        simpleMailMessage.setText("salam necesen shamil");
        simpleMailMessage.setSubject("Önemlidi bax");
        javaMailSender.send(simpleMailMessage);

        return true;
    }
}
