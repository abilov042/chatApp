package com.chatApp.business.abstractes;

import com.chatApp.entities.concretes.User;
import com.chatApp.entities.dtos.request.MailVerificationUserDto;

public interface MailSenderService {

    boolean sendMessage (User user);
    String checkCode(MailVerificationUserDto mailVerificationUserDto);

}
