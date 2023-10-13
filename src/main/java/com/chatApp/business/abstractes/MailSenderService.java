package com.chatApp.business.abstractes;

import com.chatApp.entities.concretes.User;

public interface MailSenderService {

    public boolean sendMessage (User user);

}
