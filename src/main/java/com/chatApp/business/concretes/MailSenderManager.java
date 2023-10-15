package com.chatApp.business.concretes;

import com.chatApp.business.abstractes.MailSenderService;
import com.chatApp.dataAccess.abstracts.MailVerificationUserDao;
import com.chatApp.dataAccess.abstracts.UserDao;
import com.chatApp.entities.concretes.MailVerificationUser;
import com.chatApp.entities.concretes.User;
import com.chatApp.entities.dtos.request.MailVerificationUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailSenderManager implements MailSenderService {

    private final JavaMailSender javaMailSender;
    private final MailVerificationUserDao mailVerificationUserDao;
    private final UserDao userDao;

    @Override
    public boolean sendMessage(User user) {
        // created code
        String code = createVerificationCode();

        // sending mail
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("randomislerucun123@gmail.com");
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setText("Your verification code : \n" + code);
        simpleMailMessage.setSubject("Chat app company");
        javaMailSender.send(simpleMailMessage);

        // save verification
        MailVerificationUser mailVerificationUser = new MailVerificationUser();
        // check verification exists
        // if client send mail first time yourself if operator doesn't work
        boolean checkId = mailVerificationUserDao.existsByUser_Id(user.getId());
        if(checkId){
            // update verification code
            int codeId = mailVerificationUserDao.findIdByUser_id(user.getId());
            mailVerificationUser.setId(codeId);
        }
        // if, if operator doesn't work in database created new line
        mailVerificationUser.setCode(code);
        mailVerificationUser.setUser(user);
        mailVerificationUserDao.save(mailVerificationUser);
        return true;
    }

    @Override
    public String checkCode(MailVerificationUserDto mailVerificationUserDto) {
        MailVerificationUser mailVerificationUser = mailVerificationUserDao.
                findByUser_Id(mailVerificationUserDto.getUserId());

        if(mailVerificationUser.getCode().equals(mailVerificationUserDto.getCode())){
            User user = userDao.findById(mailVerificationUserDto.getUserId());
            user.setVerify(true);
            userDao.save(user);
            return "Successfully confirmed";
        }
        else{
            return "Code not true";
        }
    }

    private String createVerificationCode(){
        String numberCase = "0123456789";
        String code = "";
        Random random = new Random();

        for(int  i = 0; i<6; i++){
            code+=numberCase.charAt(random.nextInt(10));
        }
        return code;
    }



}
